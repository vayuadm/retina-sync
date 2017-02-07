package adm.vayu.retina.sync.common;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class HttpClientImpl implements HttpClient {

    private static final String METHOD_DELETE = "DELETE";
    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";
    private static final String METHOD_PUT = "PUT";
    private static final String GZIP_ENCODING = "gzip";

    @Override
    public InputStream get(String url) {

        return doRequest(url, METHOD_GET);
    }

    @Override
    public InputStream put(String url) {

        return doRequest(url, METHOD_PUT);
    }

    @Override
    public InputStream post(String url, Map<String, String> map) {

        return doRequest(url, METHOD_POST, map);
    }

    @Override
    public InputStream delete(String url) {

        return doRequest(url, METHOD_DELETE);
    }

    private InputStream doRequest(String url, String requestMethod) {

        return doRequest(url, requestMethod, null);
    }

    private InputStream doRequest(String url, String requestMethod, Map<String, String> map) {

        InputStream ret = null;
        try {
            HttpsURLConnection conn = (HttpsURLConnection) new URL(url)
                    .openConnection();
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.setDoOutput(requestMethod.equals(METHOD_POST) || requestMethod.equals(METHOD_PUT));
            conn.setRequestMethod(requestMethod);

            if (map != null && !map.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> currEntry : map.entrySet()) {
                    sb.append(sb.length() > 0 ? "&" : "")
                            .append(currEntry.getKey())
                            .append("=")
                            .append(URLEncoder.encode(currEntry.getValue(), "UTF-8"));
                }
                conn.getOutputStream().write(sb.toString().getBytes());
                conn.getOutputStream().close();
            }

            if (conn.getResponseCode() < 400) {
                ret = getWrappedInputStream(
                        conn.getInputStream(), GZIP_ENCODING.equalsIgnoreCase(conn.getContentEncoding())
                );
            }
        } catch (Exception e) {
            throw new RetinaSyncException(e);
        }

        return ret;
    }

    private InputStream getWrappedInputStream(InputStream is, boolean gzip)
            throws IOException {

        InputStream ret;
        if (gzip) {
            ret = new BufferedInputStream(new GZIPInputStream(is));
        } else {
            ret = new BufferedInputStream(is);
        }

        return ret;
    }
}

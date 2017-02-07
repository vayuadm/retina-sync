package adm.vayu.retina.sync.common;

import java.io.InputStream;
import java.util.Map;

public interface HttpClient {

    InputStream get(String url);

    InputStream put(String url);

    InputStream post(String url, Map<String, String> map);

    InputStream delete(String url);
}

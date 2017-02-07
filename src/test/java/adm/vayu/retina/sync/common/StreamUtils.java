package adm.vayu.retina.sync.common;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class StreamUtils {

    public static InputStream toInputStream(String json) {

        return new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));
    }
}

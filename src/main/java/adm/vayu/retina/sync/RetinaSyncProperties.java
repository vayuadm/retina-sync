package adm.vayu.retina.sync;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RetinaSyncProperties {

    @Value("${alm.user}")
    private String _almUser;

    public String getAlmUser() {

        return _almUser;
    }
}

package adm.vayu.retina.sync;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RetinaSyncProperties {

    @Value("${retina.sync.interval}")
    private long _interval;
    @Value("${alm.user}")
    private String _almUser;

    public long getInterval() {

        return _interval;
    }

    public String getAlmUser() {

        return _almUser;
    }
}

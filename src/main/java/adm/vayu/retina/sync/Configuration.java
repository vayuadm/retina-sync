package adm.vayu.retina.sync;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Configuration {

    @Value("${alm.user}")
    private String almUser;

    public String getAlmUser() {

        return almUser;
    }
}

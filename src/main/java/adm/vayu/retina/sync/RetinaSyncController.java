package adm.vayu.retina.sync;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/retina-sync/")
public class RetinaSyncController {

    @RequestMapping("start")
    public String start() {

        return "Retina synchronization has been started";
    }

    @RequestMapping("health")
    public String health() {

        return "Ok";
    }
}
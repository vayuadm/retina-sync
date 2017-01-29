package adm.vayu.retina.sync;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/retina-sync/")
public class RetinaSyncController {

    @Autowired
    private RetinaSyncRunner _runner;

    @RequestMapping("start")
    public String start() {

        return _runner.start() ? "Retina synchronization has been started" : "Retina already started";
    }

    @RequestMapping("health")
    public String health() {

        return "Ok";
    }
}
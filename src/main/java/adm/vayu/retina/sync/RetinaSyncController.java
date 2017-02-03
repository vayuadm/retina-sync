package adm.vayu.retina.sync;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/retina-sync/")
public class RetinaSyncController {

    private RetinaSyncRunner _runner;

    public RetinaSyncController(RetinaSyncRunner runner) {

        _runner = runner;
    }

    @RequestMapping("start")
    public String start() {

        return _runner.start() ? "Retina synchronization has been started" : "Retina already started";
    }

    @RequestMapping("health")
    public String health() {

        return "Ok";
    }
}
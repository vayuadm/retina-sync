package adm.vayu.retina.sync;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RetinaSyncRunnerTest extends RetinaSyncTestCase {

    @Autowired
    private RetinaSyncRunner _runner;

    @Test
    public void testStart() {

        _runner.start();
        _runner.stop();
    }
}

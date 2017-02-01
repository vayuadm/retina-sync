package adm.vayu.retina.sync;

import adm.vayu.retina.sync.data.Entity;
import adm.vayu.retina.sync.trello.Trello;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.BDDMockito.given;

public class RetinaSyncRunnerTest extends RetinaSyncTestCase {

    @Autowired
    private RetinaSyncRunner _runner;

    @MockBean
    private Trello _trello;

    @Test
    public void testStart() {

        given(_trello.update(Mockito.anyListOf(Entity.class))).will(candidates -> null);
        _runner.start();
        _runner.stop();
    }
}

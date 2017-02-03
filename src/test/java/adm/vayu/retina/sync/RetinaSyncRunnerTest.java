package adm.vayu.retina.sync;

import adm.vayu.retina.sync.alm.Alm;
import adm.vayu.retina.sync.data.Connection;
import adm.vayu.retina.sync.data.Entity;
import adm.vayu.retina.sync.trello.Trello;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import static org.mockito.BDDMockito.given;

public class RetinaSyncRunnerTest extends RetinaSyncTestCase {

    private CountDownLatch _latch = new CountDownLatch(1);
    @Autowired
    private RetinaSyncRunner _runner;
    @MockBean
    private Alm _alm;
    @MockBean
    private Trello _trello;

    @Test
    public void testStart() throws Exception {

        given(_alm.getCandidates(Mockito.any(Connection.class))).willReturn(new ArrayList<>());
        given(_trello.update(Mockito.any())).willAnswer(
                invocationOnMock -> {
                    _latch.countDown();
                    return null;
                });

        _runner.start();
        _latch.await();
        _runner.stop();

        Mockito.verify(_alm).getCandidates(Mockito.any(Connection.class));
        Mockito.verify(_trello).update(Mockito.anyListOf(Entity.class));
    }
}

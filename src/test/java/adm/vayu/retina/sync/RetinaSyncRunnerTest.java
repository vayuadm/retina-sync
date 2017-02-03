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
import java.util.concurrent.Semaphore;

import static org.mockito.BDDMockito.given;

public class RetinaSyncRunnerTest extends RetinaSyncTestCase {

    private final Semaphore _semaphore = new Semaphore(1);
    @Autowired
    private RetinaSyncRunner _runner;
    @MockBean
    private Alm _alm;
    @MockBean
    private Trello _trello;

    @Test
    public void testStart() throws Exception {

        given(_alm.getCandidtes(Mockito.any(Connection.class))).willReturn(new ArrayList<>());
        given(_trello.update(Mockito.anyListOf(Entity.class))).willAnswer(
                invocationOnMock -> {
                    _semaphore.release();
                    return null;
                });

        _runner.start();
        _semaphore.tryAcquire();
        _runner.stop();

        Mockito.verify(_alm).getCandidtes(Mockito.any(Connection.class));
        Mockito.verify(_trello).update(Mockito.anyListOf(Entity.class));
    }
}

package adm.vayu.retina.sync.trello;

import adm.vayu.retina.sync.RetinaSyncTestCase;
import adm.vayu.retina.sync.common.HttpClient;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.BDDMockito.given;

public class TrelloClientTest extends RetinaSyncTestCase {

    @Autowired
    private TrelloClient _trello;
    @MockBean
    private HttpClient _http;

    @Test
    public void testGetBoardCards() {

        given(_http.get(Mockito.anyString())).willReturn(TrelloMockEntity.getCards());

        _trello.initialize("mykey", "mytoken");
        Assert.assertEquals(3, _trello.getBoardCards("myboard").size());
    }
}

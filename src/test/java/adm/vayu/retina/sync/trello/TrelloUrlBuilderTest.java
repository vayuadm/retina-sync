package adm.vayu.retina.sync.trello;

import org.junit.Assert;
import org.junit.Test;

public class TrelloUrlBuilderTest {

    @Test
    public void testBoardCards() throws Exception {

        Assert.assertEquals("https://api.trello.com/1/boards/vayu/cards?key=mykey&token=mytoken",
                new TrelloUrlBuilder("mykey", "mytoken").boardCards("vayu"));
    }
}

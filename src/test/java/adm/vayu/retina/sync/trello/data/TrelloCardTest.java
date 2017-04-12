package adm.vayu.retina.sync.trello.data;

import org.junit.Assert;
import org.junit.Test;

public class TrelloCardTest {

    @Test
    public void testToMap() {

        TrelloCard card = new TrelloCard();
        card.setIdList("aaa_candidates_bbb");
        card.setName("create lambda for removing aws instances");
        Assert.assertEquals(2, card.toMap().size());
    }
}

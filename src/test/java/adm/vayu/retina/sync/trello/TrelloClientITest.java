package adm.vayu.retina.sync.trello;

import adm.vayu.retina.sync.RetinaSyncTestCase;
import adm.vayu.retina.sync.trello.data.TrelloCard;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;

public class TrelloClientITest extends RetinaSyncTestCase {

    @Autowired
    private TrelloClient _trello;

    @Test
    public void testCreateCards() {

        _trello.initialize("4c0c2580919278b5313488f4756549ef",
                "b2dfe471b57dbe6a383c4f2d48b9aa7f4a0858ea99d4e4d0b16152244a979d05");
        TrelloCard card = new TrelloCard();
        card.setIdList("58edf0e2cff95493eddc395c");
        card.setName("Been here");

        _trello.createCards(Arrays.asList(card));
    }
}

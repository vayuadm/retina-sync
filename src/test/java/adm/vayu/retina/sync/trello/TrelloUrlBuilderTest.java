package adm.vayu.retina.sync.trello;

import adm.vayu.retina.sync.trello.data.TrelloCard;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TrelloUrlBuilderTest {

    @Test
    public void testBoardCards() {

        final String BOARD_ID = "58edeec1e112f18325e0efa6";
        Assert.assertEquals(String.format("https://api.trello.com/1/boards/%s/cards?key=mykey&token=mytoken", BOARD_ID),
                new TrelloUrlBuilder("mykey", "mytoken").boardCards(BOARD_ID));
    }

    @Test
    public void testCreateCard() {

        final String CARD_NAME = "new card";
        final String CARD_IDLIST = "58ede1sssd18325e0efa6";
        final String KEY = "mykey";
        final String TOKEN = "mytoken";

        TrelloCard card = new TrelloCard();
        card.setName(CARD_NAME);
        card.setIdList(CARD_IDLIST);

        Set<String> expectedParams = new HashSet<>();
        expectedParams.add(CARD_IDLIST);
        expectedParams.add(CARD_NAME);
        expectedParams.add(KEY);
        expectedParams.add(TOKEN);

        String url = new TrelloUrlBuilder(KEY, TOKEN).createCard(card);

        String[] parts = url.split("\\?");
        Assert.assertEquals(2, parts.length);
        Assert.assertEquals("https://api.trello.com/1/cards", parts[0]);

        String[] params = parts[1].split("&");
        Assert.assertEquals(expectedParams.size(), params.length);
        for (String item : params) {
            Assert.assertTrue(expectedParams.contains(item.split("=")[1]));
        }
    }
}

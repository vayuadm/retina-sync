package adm.vayu.retina.sync.trello;

import adm.vayu.retina.sync.trello.data.TrelloCard;
import com.google.gson.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class TrelloObjectFactoryTest {

    @Test
    public void testCreateObjectNullContent() {

        Assert.assertEquals(
                new TrelloObjectFactory().createObject(
                        new TypeToken<List<TrelloCard>>() {
                        }, null),
                Collections.emptyList());
    }

    @Test
    public void testCreateCard() {

        Assert.assertEquals(3, new TrelloObjectFactory().createObject(
                new TypeToken<List<TrelloCard>>() {
                }, TrelloMockEntity.getCards()).size());
    }
}

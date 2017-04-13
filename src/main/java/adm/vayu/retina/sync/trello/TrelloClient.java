package adm.vayu.retina.sync.trello;

import adm.vayu.retina.sync.common.HttpClient;
import adm.vayu.retina.sync.configuration.RetinaSyncConfig;
import adm.vayu.retina.sync.trello.data.TrelloCard;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrelloClient {

    private final TrelloObjectFactory _factory = new TrelloObjectFactory();
    private final HttpClient _httpClient;
    private TrelloUrlBuilder _urlBuilder;

    private TrelloClient(RetinaSyncConfig config) {

        _httpClient = config.httpClient();
    }

    void initialize(String apiKey, String token) {

        _urlBuilder = new TrelloUrlBuilder(apiKey, token);
    }

    List<TrelloCard> getBoardCards(String boardId) {

        return _factory.createObject(
                new TypeToken<List<TrelloCard>>() {
                }, _httpClient.get(_urlBuilder.boardCards(boardId)));
    }

    void createCards(List<TrelloCard> cards) {

        for (TrelloCard currCard : cards) {
            _httpClient.post(_urlBuilder.createCard(currCard), currCard.toMap());
        }
    }
}
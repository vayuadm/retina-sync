package adm.vayu.retina.sync.trello;

import adm.vayu.retina.sync.trello.data.TrelloCard;

class TrelloUrlBuilder {

    private static final String BOARD_CARDS = "/boards/%1$s/cards";
    private static final String CARDS = "/cards";

    private static final String KEY_QUERY_PARAM = "key=";
    private static final String TOKEN_QUERY_PARAM = "&token=";

    private final String _apiKey;
    private final String _token;

    TrelloUrlBuilder(String apiKey, String token) {

        _apiKey = apiKey;
        _token = token;
    }

    String boardCards(String boardId) {

        return build(BOARD_CARDS, boardId);
    }

    String createCard(TrelloCard card) {

        return build(CARDS);
    }

    private String build(String urlSuffix, String... params) {

        return String.format("https://api.trello.com/1%1$s?%2$s",
                params == null ? urlSuffix : String.format(urlSuffix, (Object[]) params),
                createQueryString());
    }

    private String createQueryString() {

        StringBuilder ret = new StringBuilder(KEY_QUERY_PARAM).append(_apiKey);
        if (_token != null) {
            ret.append(TOKEN_QUERY_PARAM).append(_token);
        }

        return ret.toString();
    }
}

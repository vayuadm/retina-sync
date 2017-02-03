package adm.vayu.retina.sync.trello;

class TrelloUrlBuilder {

    private static final String TRELLO_BASE_URL = "";
    private static final String BOARD_CARDS = "/boards/%1$s/cards";

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

    private String build(String urlSuffix, String... params) {

        return String.format("https://api.trello.com/1%s?%s",
                String.format(urlSuffix, (Object[]) params),
                createAuthQueryString());
    }

    private String createAuthQueryString() {

        StringBuilder sb = new StringBuilder(KEY_QUERY_PARAM).append(_apiKey);
        if (_token != null) {
            sb.append(TOKEN_QUERY_PARAM).append(_token);
        }

        return sb.toString();
    }
}

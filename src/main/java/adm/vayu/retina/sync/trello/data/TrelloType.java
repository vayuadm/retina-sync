package adm.vayu.retina.sync.trello.data;

public enum TrelloType {

    ORGANIZATION,
    ACTION,
    BOARD,
    CHECKLIST,
    LIST,
    MEMBER,
    NOTIFICATION,
    UNKNOWN;

    TrelloType() {
    }

    public static TrelloType fromString(String str) {

        TrelloType type = TrelloType.UNKNOWN;
        try {
            type = TrelloType.valueOf(str.toUpperCase());
        } catch (Exception e) {
            // do nothing
        }
        return type;
    }
}
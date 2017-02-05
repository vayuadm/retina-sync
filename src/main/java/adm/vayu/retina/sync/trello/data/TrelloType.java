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

    public static TrelloType fromString(String type) {

        TrelloType ret = TrelloType.UNKNOWN;
        try {
            ret = TrelloType.valueOf(type.toUpperCase());
        } catch (Exception e) {
            // do nothing
        }

        return ret;
    }
}
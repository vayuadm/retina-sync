package adm.vayu.retina.sync.trello.data;

public abstract class TrelloObject {

    private String id;

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    @Override
    public String toString() {
        
        return String.format("%s ID: %s", getClass().getSimpleName(), id);
    }
}

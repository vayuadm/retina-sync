package adm.vayu.retina.sync.trello;

import adm.vayu.retina.sync.data.Entity;

import java.util.List;

public interface Trello {

    Void update(List<Entity> candidates);
}

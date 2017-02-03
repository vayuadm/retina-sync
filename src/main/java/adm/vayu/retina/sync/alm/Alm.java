package adm.vayu.retina.sync.alm;

import adm.vayu.retina.sync.data.Connection;
import adm.vayu.retina.sync.data.Entity;

import java.util.List;

public interface Alm {

    List<Entity> getCandidates(Connection connection);
}

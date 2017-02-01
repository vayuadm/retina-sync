package adm.vayu.retina.sync;

import adm.vayu.retina.sync.data.Connection;

class ConnectionFactory {

    static Connection create(RetinaSyncProperties properties) {

        return new Connection(properties.getAlmUser());
    }
}

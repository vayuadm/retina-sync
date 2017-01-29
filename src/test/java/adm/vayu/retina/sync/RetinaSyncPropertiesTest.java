package adm.vayu.retina.sync;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RetinaSyncPropertiesTest extends RetinaSyncTestCase {

    @Autowired
    private RetinaSyncProperties _properties;

    @Test
    public void testGetAlmUser() {

        Assert.assertFalse(_properties.getAlmUser().isEmpty());
    }
}

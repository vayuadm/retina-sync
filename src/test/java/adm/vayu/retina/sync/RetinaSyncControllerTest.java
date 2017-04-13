package adm.vayu.retina.sync;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class RetinaSyncControllerTest extends RetinaSyncTestCase {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testHealth() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/retina-sync/health").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

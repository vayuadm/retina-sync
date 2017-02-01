package adm.vayu.retina.sync.configuration;

import adm.vayu.retina.sync.trello.Trello;
import adm.vayu.retina.sync.trello.TrelloImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetinaSyncConfig {

    @Bean
    public Trello trello() {

        return new TrelloImpl();
    }
}

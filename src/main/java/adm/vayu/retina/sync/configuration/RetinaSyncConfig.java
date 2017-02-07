package adm.vayu.retina.sync.configuration;

import adm.vayu.retina.sync.alm.Alm;
import adm.vayu.retina.sync.alm.AlmImpl;
import adm.vayu.retina.sync.common.HttpClient;
import adm.vayu.retina.sync.common.HttpClientImpl;
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

    @Bean
    public Alm alm() {

        return new AlmImpl();
    }

    @Bean
    public HttpClient httpClient() {

        return new HttpClientImpl();
    }
}

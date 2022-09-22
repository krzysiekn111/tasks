package com.crud.tasks.trello.client;

import com.crud.tasks.trello.config.TrelloConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.util.UriComponentsBuilder;
import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;

@SpringBootTest
public class TrelloClientConfigTest {

    @Autowired
    TrelloConfig trelloConfig;

    @Test
    void shouldReturnTrelloData() {
        //given
        URI url2 = UriComponentsBuilder
                .fromHttpUrl("https://api.trello.com/1" + "/members/" + "krzysztofnosal1" + "/boards")
                .queryParam("key", "b327ab610b95b575cb1944ad78f363cb")
                .queryParam("token", "412e78e5f6dd6a8807c7633ccacbef1cded0cc5337205683c3b91856a24f051b")
                .queryParam("fields", "name,id")
                .queryParam("lists", "all")
                .build()
                .encode()
                .toUri();
        URI url = UriComponentsBuilder
                .fromHttpUrl(trelloConfig.getTrelloApiEndpoint() + "/members/" + trelloConfig.getTrelloUser() + "/boards")
                .queryParam("key", trelloConfig.getTrelloAppKey())
                .queryParam("token", trelloConfig.getTrelloToken())
                .queryParam("fields", "name,id")
                .queryParam("lists", "all")
                .build()
                .encode()
                .toUri();
        //then
        assertEquals(url2, url);

    }
}

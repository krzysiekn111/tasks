package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TrelloClinetMappersTest {

        @Autowired
        TrelloMapper myTrelloMapper;

    @Test
    void TestMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "high", "1");
        //When
        TrelloCard trelloCard = myTrelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals("name", trelloCard.getName());
        assertEquals("description", trelloCard.getDescription());
        assertEquals("high", trelloCard.getPos());
        assertEquals("1", trelloCard.getListId());
    }

    @Test
    void testMaptoCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("name", "opis", "low", "5");
        //When
        TrelloCardDto trelloCardDto = myTrelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("name", trelloCardDto.getName());
        assertEquals("opis", trelloCardDto.getDescription());
        assertEquals("low", trelloCardDto.getPos());
        assertEquals("5", trelloCardDto.getListId());
    }
}

package com.crud.tasks.trello.validator;


import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrelloValidatorTest {

    TrelloValidator validator = new TrelloValidator();

    @Test
    void validateTrelloBoards() {
        //given
        List<TrelloList> trelloLists =
                List.of(new TrelloList("1", "name", false));

        List<TrelloBoard> trelloBoards =
                List.of(
                        new TrelloBoard("1", "test", trelloLists),
                        new TrelloBoard("1", "name", trelloLists)
                );

        //when
        List<TrelloBoard> validatedList = validator.validateTrelloBoards(trelloBoards);

        //then
        assertEquals(1, validatedList.size());

    }
}
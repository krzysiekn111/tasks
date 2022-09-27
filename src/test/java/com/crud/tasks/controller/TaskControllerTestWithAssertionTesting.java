package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskControllerTestWithAssertionTesting {

    @Autowired
    TaskController taskController;


    @Test
    void getTasks() {
        //when & then
        Assertions.assertDoesNotThrow(()->taskController.getTasks());
    }

    @Test
    void getTask(){
        //given
        boolean threwException = false;

        //when
        try {
            ResponseEntity<TaskDto> response = taskController.getTask(-1L);
        }catch (TaskNotFoundException e){
            threwException = true;
        }

        //then
        assertTrue(threwException);
    }


    @Test
    void createTaskTest() {
        //given
        TaskDto taskToBeSaved = new TaskDto(1L,"title", "content");
        //when
        int before = taskController.getTasks().getBody().size();
        taskController.createTask(taskToBeSaved);
        int after = taskController.getTasks().getBody().size();

        //then
        assertTrue(after > before);
    }
    @Test
    void DeleteTaskTest() {
        //given
        TaskDto taskToBeSaved = new TaskDto(1L,"title", "content");
        //when
        int before = taskController.getTasks().getBody().size();
        List<TaskDto> tasks = taskController.getTasks().getBody();
        TaskDto addedTask = tasks.get(tasks.size()-1);
        taskController.deleteTask(addedTask.getId());
        int after = taskController.getTasks().getBody().size();
        //then
        assertTrue(before > after);
    }


}
//package com.crud.tasks.controller;
//import com.crud.tasks.mapper.TaskMapper;
//import com.crud.tasks.service.DbService;
//import com.google.gson.Gson;
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import static org.mockito.ArgumentMatchers.any;
//import com.crud.tasks.domain.*;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
//
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//
//@SpringJUnitWebConfig
//@WebMvcTest(DbService.class)
//class TaskControllerTest {
//
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private DbService dbService;
//
//    @Test
//    void getTasks() throws Exception {
//        TaskDto taskDto = new TaskDto(1L, "title", "content");
//        Task task = new Task(1L, "title", "content");
//        when(dbService.getAllTasks()).thenReturn((List.of(task)));
//
//        //When & Then
//        mockMvc
//                .perform(MockMvcRequestBuilders
//                        .get("/v1/tasks")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1L)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title", Matchers.is("title")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].content", Matchers.is("content")));
//    }
//
//
//    @Test
//    void getTask() throws Exception {
//        // Given
//        TaskDto taskDto = new TaskDto(1L, "title", "content");
//        Task task = new Task(1L, "title", "content");
//        when(dbService.getTask(any(Long.class))).thenReturn(task);
//
//        //When & Then
//        mockMvc
//                .perform(MockMvcRequestBuilders
//                        .get("/v1/tasks")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1L)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("title")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.is("content")));
//
//
//    }
//
//    @Test
//    void deleteTask() {
//    }
//
//    @Test
//    void updateTask() {
//    }
//
//    @Test
//    void createTask() throws Exception {
//        // Given
//        TaskDto taskDto = new TaskDto(1L, "title", "content");
//        Task task = new Task(1L, "title", "content");
//
//        when(dbService.saveTask(any(Task.class))).thenReturn(task);
//        Gson gson = new Gson();
//        String jsonContent = gson.toJson(taskDto);
//
//        //When & Then
//        mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/v1/trello/cards")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .characterEncoding("UTF-8")
//                        .content(jsonContent))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is("232")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Test")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.shortUrl", Matchers.is("http://test.com")));
//    }
//}
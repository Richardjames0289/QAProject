package qAProject.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import qAProject.domain.ToDoList;
import qAProject.service.ToDoListService;

@RunWith(SpringRunner.class)
@WebMvcTest

public class ToDoListControllerUnitTest {

@Autowired
private MockMvc mvc;

@Autowired
private ObjectMapper mapper;

@MockBean
private ToDoListService service;

@Test
public void createTest() throws Exception {
	ToDoList entry = new ToDoList("Dog", "Shopping", "Project");
	String entryAsJSON = this.mapper.writeValueAsString(entry);
	
	Mockito.when(this.service.create(entry)).thenReturn(entry);
	
	
	mvc.perform(post("/todolist/create")
	.contentType(MediaType.APPLICATION_JSON)
	.content(entryAsJSON))
	.andExpect(status().isCreated())
	.andExpect(content().json(entryAsJSON));
}
@Test
public void readAllTest() throws Exception {
ToDoList entry = new ToDoList("Dog", "Shopping", "Project");
List<ToDoList> output = new ArrayList<>();
output.add(entry);
String outputAsJSON = this.mapper.writeValueAsString(output);
Mockito.when(this.service.readAll()).thenReturn(output);
mvc.perform(get("/todolist/Read")
.contentType(MediaType.APPLICATION_JSON))
.andExpect(status().isOk())
.andExpect(content().json(outputAsJSON));
}

@Test
public void getOneTest() throws Exception {
ToDoList entry = new ToDoList("Dog", "Shopping", "Project");
String entryAsJSON = this.mapper.writeValueAsString(entry);
Mockito.when(this.service.read(1L)).thenReturn(entry);
mvc.perform(get("/todolist/read/1")
.contentType(MediaType.APPLICATION_JSON))
.andExpect(status().isOk())
.andExpect(content().json(entryAsJSON));
}

@Test
public void updateTest() throws Exception {
ToDoList entry = new ToDoList("Dog", "Shopping", "Project");
String entryAsJSON = this.mapper.writeValueAsString(entry);
Mockito.when(this.service.update(entry, 1L)).thenReturn(entry);
mvc.perform(put("/todolist/update/1")
.contentType(MediaType.APPLICATION_JSON)
.content(entryAsJSON))
.andExpect(status().isAccepted())
.andExpect(content().json(entryAsJSON));
}

@Test
public void deleteSuccessTest() throws Exception {
Mockito.when(this.service.delete(1L)).thenReturn(true);
mvc.perform(delete("/todolist/delete/1")
.contentType(MediaType.APPLICATION_JSON))
.andExpect(status().isNoContent());
}
@Test
public void deleteFailTest() throws Exception {
Mockito.when(this.service.delete(1L)).thenReturn(false);
mvc.perform(delete("/todolist/remove/1")
.contentType(MediaType.APPLICATION_JSON))
.andExpect(status().isNotFound());
}


}

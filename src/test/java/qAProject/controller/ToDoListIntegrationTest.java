package qAProject.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.fasterxml.jackson.databind.ObjectMapper;

import qAProject.domain.ToDoList;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class ToDoListIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void createTest() throws Exception {
		ToDoList entry = new ToDoList("Dog","Shopping","Project");
		ToDoList result = new ToDoList(2L, "Dog", "Shopping", "Project");
		
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);
		
		mvc.perform(post("/todolist/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(status().isCreated())
			.andExpect(content().json(resultAsJSON));

	
	}	
	@Test
	public void readAllTest() throws Exception {
	ToDoList entry = new ToDoList(1L, "Dog", "Shopping", "Project");
	List<ToDoList> output = new ArrayList<>();
	output.add(entry);
	String outputAsJSON = this.mapper.writeValueAsString(output);
	mvc.perform(get("/todolist/Read")
	.contentType(MediaType.APPLICATION_JSON))
	.andExpect(status().isOk())
	.andExpect(content().json(outputAsJSON));
	}
	@Test
	public void readByIdTest() throws Exception {
	ToDoList entry = new ToDoList(1L, "Dog", "Shopping", "Project");
	String entryAsJSON = this.mapper.writeValueAsString(entry);
	mvc.perform(get("/todolist/read/1")
	.contentType(MediaType.APPLICATION_JSON))
	.andExpect(status().isOk())
	.andExpect(content().json(entryAsJSON));
	}
	@Test
	public void deleteSuccessTest() throws Exception {
	mvc.perform(delete("/todolist/delete/1")
	.contentType(MediaType.APPLICATION_JSON))
	.andExpect(status().isNoContent());
	}
	
	@Test
	public void updateTest() throws Exception {
	ToDoList entry = new ToDoList("Dog", "Shopping", "Project");
	String entryAsJSON = this.mapper.writeValueAsString(entry);
	ToDoList result = new ToDoList(1L, "Dog", "Shopping", "Project");
	String resultAsJSON = this.mapper.writeValueAsString(result);
	mvc.perform(put("/todolist/update/1")
	.contentType(MediaType.APPLICATION_JSON)
	.content(entryAsJSON))
	.andExpect(status().isAccepted())
	.andExpect(content().json(resultAsJSON));
	}
	
	}



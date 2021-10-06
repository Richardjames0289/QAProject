package qAProject.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import qAProject.domain.ToDoList;
import qAProject.repo.ToDoListRepo;

@RunWith(MockitoJUnitRunner.class)
public class ToDoListServiceTest {
	
	@InjectMocks
	private ToDoListService service;
	
	@Mock
	private ToDoListRepo repo;
	
	@Test
	public void createTest() {
		ToDoList input = new ToDoList("Dog","Shopping","Project");
		ToDoList output = new ToDoList(1L,"Dog","Shopping","Project");
		
		Mockito.when(this.repo.save(input)).thenReturn(output);
		assertEquals(output, this.service.create(input));
		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}
	@Test
	public void readAllTest() {
		List<ToDoList> output = new ArrayList<>();
		output.add(new ToDoList("Dog","Shopping","Project"));
		
		Mockito.when(this.repo.findAll()).thenReturn(output);
		assertEquals(output, this.service.readAll());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
		}
	
	@Test
	public void readTest() {
	    
	        when(repo.findById(1L)).thenReturn(new ToDoList(1L,"Dog","Shopping","Project"));
	         
	        ToDoList toDoList = service.read.findById((long) 1);
	        
	        
	        assertEquals(output, this.service.read(1L));
	        
	    }
	}




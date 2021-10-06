package qAProject.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	        Optional<ToDoList> OptionalOutput = Optional.of(new ToDoList(1L,"Dog", "Shopping","Project"));
	        ToDoList output = new ToDoList(1L, "Dog", "Shopping","Project");

	 

	        Mockito.when(this.repo.findById(1L)).thenReturn(OptionalOutput);

	 

	        assertEquals(output, this.service.read(1l));

	 

	        Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
	    }
	    
	    @Test
	    public void updateTest() {
	        ToDoList input = new ToDoList("Dog", "Shopping", "Project");
	        Optional<ToDoList> existing = Optional.of(new ToDoList(1L, "Dog", "Shopping", "Project"));
	        ToDoList output = new ToDoList(1L, "Dog", "Shopping", "Project");
	       
	        Mockito.when(this.repo.findById(1L)).thenReturn(existing);
	        Mockito.when(this.repo.saveAndFlush(output)).thenReturn(output);
	       
	        assertEquals(output, this.service.update(input, 1L));
	       
	        Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
	        Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(output);
	    }
	    
	    @Test
	    public void deleteTrueTest() {
	        Mockito.when(this.repo.existsById(1L)).thenReturn(false);
	       
	        assertTrue(this.service.delete(1L));
	       
	        Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
	        Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
	    }
	   
	    @Test
	    public void deleteFalseTest() {
	        Mockito.when(this.repo.existsById(1L)).thenReturn(true);
	       
	        assertFalse(this.service.delete(1L));
	       
	        Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
	        Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
	    }
//	    @Test
//	    public void findByNameTest() {
//		        Optional<ToDoList> OptionalOutput = Optional.of(new ToDoList(1L,"Dog", "Shopping","Project"));
//		        ToDoList output = new ToDoList(1L, "Dog", "Shopping","Project");
//
//		 
//
//		        Mockito.when(this.repo.readByName("Dog").thenReturn(OptionalOutput);
//
//		 
//
//		        assertEquals(output, this.service.readByName("Dog"));
//
//		 
//
//		        Mockito.verify(this.repo, Mockito.times(1)).readByName("Dog");
//		    }
//	    
	    
	}




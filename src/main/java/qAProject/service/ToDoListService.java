package qAProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import qAProject.domain.ToDoList;
import qAProject.repo.ToDoListRepo;

@Service
public class ToDoListService {

	private ToDoListRepo repo;

	@Autowired
	public ToDoListService(ToDoListRepo repo) {
		this.repo = repo;
	}

//create

	public ToDoList create(ToDoList a) {
		return this.repo.save(a);

	}

//ReadAll

	public List<ToDoList> readAll() {
		List<ToDoList> result = this.repo.findAll();
		System.out.println(result);
		return result;
		
	}
//Read id

	public ToDoList read(long id) {
		return this.repo.findById(id).get();
	}

//update
	public ToDoList update(ToDoList a, long id) {
		ToDoList exists = this.repo.findById(id).orElseThrow();
		exists.setTodo1(a.getTodo1());
		exists.setTodo2(a.getTodo2());
		exists.setTodo3(a.getTodo3());
		return this.repo.saveAndFlush(exists);
	}

//delete
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

////Findbyname
//	public List<ToDoList> readByName(String object) {
//		return this.repo.readByName(object);
//	}

}

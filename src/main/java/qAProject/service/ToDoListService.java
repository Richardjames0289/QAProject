package qAProject.service;

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
		return this.repo.saveAndFlush(a);
	}

//ReadAll

	public List<ToDoList> readAll() {
		return this.repo.findAll();
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
		if (!this.repo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Object Found");
		}
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

//Findbyname
	public List<ToDoList> findByName(String object) {
		return this.repo.findByName(object);
	}

}

package qAProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {

	private ToDoList repo;

	@Autowired
	public ToDoListService(ToDoListRepo repo) {
		this.repo = repo;
	}

//create
	public ToDoList create(ToDoList a) {
		return this.repo();
	}
//ReadAll

	public List<ToDoList> readAll() {
		return this.repo.findAll();
	}
//Read id

public ToDoList read(long id) {
	return this,repo.findById(id).get();
}

//update
	public ToDoList update(ToDoList a, long id) {
		ToDoList exists = this.repo.findById(id).orElseThrow(ToDoListNotFoundException::new);
		exists.setTodo1(a.getTodo1());
		exists.setTodo2(a.getTodo2());
		exists.setTodo3(a.getTodo3());
		return this.repo.saveAndFlush(exists);
	}

//delete
	public boolean delete(long id) {
		if (!this.repo.existsById(id)) {
			throw new ToDoListNotFoundException();
		}
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
//Findbyname
public List<ToDoList> findByName(String object) {
	return this.repo.findbyname(object);
}

}

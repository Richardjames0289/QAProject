package qAProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qAProject.domain.ToDoList;
import qAProject.service.ToDoListService;

@RestController
@RequestMapping("/todolist")
public class ToDoListController {

@Autowired
private ToDoListService service;

//create
@PostMapping("/create")
public ResponseEntity<ToDoList> create(@RequestBody ToDoList a) {
	return new ResponseEntity <ToDoList> (this.service.create(a), HttpStatus.CREATED);
}

//Read
@GetMapping("/Read")
public ResponseEntity<List<ToDoList>> readAll() {
	return new ResponseEntity <List<ToDoList>>(this.service.readAll(), HttpStatus.OK);
}
//ReadId
@GetMapping("/read/{id}")
public ResponseEntity<ToDoList> read(@PathVariable long id) {
	return new ResponseEntity <ToDoList>(this.service.read(id), HttpStatus.OK);
}
//Update
@PutMapping("/update/{id}")
public ResponseEntity<ToDoList> update(@PathVariable long id, @RequestBody ToDoList a) {
	return new ResponseEntity<ToDoList>(this.service.update(a, id), HttpStatus.ACCEPTED);
}
//delete 
@DeleteMapping("/delete/{id}")
public ResponseEntity<Boolean> delete(@PathVariable long id) {
	return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);
}
////Findbyobject
//@GetMapping("/readobject/{object}")
//public ResponseEntity <List<ToDoList>>findByObject (@PathVariable String object) {
//	return new ResponseEntity <List<ToDoList>>(this.service.readByName(object), HttpStatus.OK);
//}
}
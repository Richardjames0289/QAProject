package qAProject.domain;


import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDoList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;
	private String todo1;
	private String todo2;
	private String todo3;
	
	public String getTodo3() {
		return todo3;
	}
	public void setTodo3(String todo3) {
		this.todo3 = todo3;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTodo1() {
		return todo1;
	}
	public void setTodo1(String todo1) {
		this.todo1 = todo1;
	}
	public String getTodo2() {
		return todo2;
	}
	public void setTodo2(String todo2) {
		this.todo2 = todo2;
	}
	public ToDoList(long id, String todo1, String todo2, String todo3) {
		super();
		this.id = id;
		this.todo1 = todo1;
		this.todo2 = todo2;
		this.todo3 = todo3;
	}
	public ToDoList() {
		super();
	}
	public ToDoList(String todo1, String todo2, String todo3) {
		super();
		this.todo1 = todo1;
		this.todo2 = todo2;
		this.todo3 = todo3;
	}
	@Override
	public String toString() {
		return "ToDoListDomain [id=" + id + ", todo1=" + todo1 + ", todo2=" + todo2 + ", todo3=" + todo3
				+ ", getTodo3()=" + getTodo3() + ", getId()=" + getId() + ", getTodo1()=" + getTodo1() + ", getTodo2()="
				+ getTodo2() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, todo1, todo2, todo3);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToDoList other = (ToDoList) obj;
		return id == other.id && Objects.equals(todo1, other.todo1) && Objects.equals(todo2, other.todo2)
				&& Objects.equals(todo3, other.todo3);
	}

	
	
	
	
	
}
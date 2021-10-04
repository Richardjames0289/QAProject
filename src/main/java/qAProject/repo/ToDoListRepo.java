package qAProject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import qAProject.domain.ToDoList;

@Repository
public interface ToDoListRepo extends JpaRepository< ToDoList, Long> {

		@Query(value = "SELECT * FROM ToDoList Where todo1 = ?1", nativeQuery = true)
		List<ToDoList>findByName(String object);
}

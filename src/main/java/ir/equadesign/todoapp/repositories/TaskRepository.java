package ir.equadesign.todoapp.repositories;

import ir.equadesign.todoapp.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}

package ir.equadesign.todoapp.services;

import ir.equadesign.todoapp.domain.Task;

import java.util.List;

public interface TaskService {

    void markAsDone(Integer id);

    void markAsUnDone(Integer id);

    void createTask(Task task);

    void deleteTask(Integer id);

    List<Task> findAll();
}

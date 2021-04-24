package ir.equadesign.todoapp.services;

import ir.equadesign.todoapp.domain.Task;
import ir.equadesign.todoapp.web.commands.TaskCommand;

import java.util.List;

public interface TaskService {

    void markAsDone(Integer id);

    void markAsUnDone(Integer id);

    void createTaskCommand(TaskCommand taskCommand);

    void deleteTask(Integer id);

    List<Task> findAll();

}

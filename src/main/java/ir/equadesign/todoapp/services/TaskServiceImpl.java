package ir.equadesign.todoapp.services;

import ir.equadesign.todoapp.domain.Task;
import ir.equadesign.todoapp.exceptions.NotFoundException;
import ir.equadesign.todoapp.repositories.TaskRepository;
import ir.equadesign.todoapp.web.commands.TaskCommand;
import ir.equadesign.todoapp.web.mapeprs.TaskMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    @Override
    public void markAsDone(Integer id) {
        var taskOptional = taskRepository.findById(id);

        if (taskOptional.isEmpty())
            throw new NotFoundException("Task Not Found");

        var task = taskOptional.get();
        task.setIsDone(true);
        taskRepository.save(task);
    }

    @Override
    public void markAsUnDone(Integer id) {
        var taskOptional = taskRepository.findById(id);

        if (taskOptional.isEmpty())
            throw new NotFoundException("Task Not Found");

        var task = taskOptional.get();
        task.setIsDone(false);
        taskRepository.save(task);
    }

    @Override
    public void createTaskCommand(TaskCommand taskCommand) {
        taskCommand.setIsDone(false);
        taskRepository.save(taskMapper.taskCommandToTask(taskCommand));
    }

    @Override
    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }
}

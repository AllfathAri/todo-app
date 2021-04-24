package ir.equadesign.todoapp.web.mapeprs;

import ir.equadesign.todoapp.domain.Task;
import ir.equadesign.todoapp.web.commands.TaskCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskCommand taskToTaskCommand(Task task);

    Task taskCommandToTask(TaskCommand taskCommand);

}

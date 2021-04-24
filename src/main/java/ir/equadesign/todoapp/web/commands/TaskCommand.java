package ir.equadesign.todoapp.web.commands;

import ir.equadesign.todoapp.domain.Category;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class TaskCommand {

    private Boolean isDone;

    @NotEmpty
    private String Details;

    private Category category;

}

package ir.equadesign.todoapp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@EqualsAndHashCode(callSuper = false, exclude = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task extends BaseEntity {

    private Boolean isDone = false;
    private String details;

    @ManyToMany
    @JoinTable(name = "Category_Task",
            joinColumns = @JoinColumn(name = "Task_ID"),
            inverseJoinColumns = @JoinColumn(name = "Category_ID"))
    private Set<Category> categories = new HashSet<>();

    @Builder
    public Task(int id,String details) {
        super(id);
        this.details = details;
    }
}

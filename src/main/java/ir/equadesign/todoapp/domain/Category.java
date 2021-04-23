package ir.equadesign.todoapp.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = false, exclude = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends BaseEntity {

    private String category;

    @ManyToMany(mappedBy = "categories")
    private Set<Task> tasks = new HashSet<>();

    @Builder
    public Category(Integer id, String category, Set<Task> tasks) {
        super(id);
        this.category = category;

        if (tasks != null){
            this.tasks = tasks;
        }
    }

    public Category addTasks(Task... tasks){
        for (Task task : tasks) {
            task.getCategories().add(this);
            this.tasks.add(task);
        }
        return this;
    }
}
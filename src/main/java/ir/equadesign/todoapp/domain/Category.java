package ir.equadesign.todoapp.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = false, exclude = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends BaseEntity {

    private String category;

    @OneToMany
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
        }
        return this;
    }

    @Override
    public String toString() {
        return category.toString();
    }
}

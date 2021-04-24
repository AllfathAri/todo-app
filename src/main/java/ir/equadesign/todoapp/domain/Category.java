package ir.equadesign.todoapp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = false, exclude = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Category {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String category;

    @OneToMany
    @Builder.Default
    private Set<Task> tasks = new HashSet<>();

    public Category addTasks(Task... tasks) {
        for (Task task : tasks) {
            task.setCategory(this);
            this.getTasks().add(task);
        }
        return this;
    }

    @Override
    public String toString() {
        return category.toString();
    }
}

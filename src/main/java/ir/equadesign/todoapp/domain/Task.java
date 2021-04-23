package ir.equadesign.todoapp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task extends BaseEntity {

    private Boolean isDone;
    private String details;

    @ManyToOne
    private Category category;

    @Builder
    public Task(Integer id, Boolean isDone, String details, Category category) {
        super(id);
        this.isDone = isDone;
        this.details = details;
        this.category = category;
    }

}

package ir.equadesign.todoapp.bootstrap;

import ir.equadesign.todoapp.domain.Category;
import ir.equadesign.todoapp.domain.Task;
import ir.equadesign.todoapp.repositories.CategoryRepository;
import ir.equadesign.todoapp.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;

@Profile("h2")
@Component
@RequiredArgsConstructor
public class H2Initializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {

        var allCategory = categoryRepository.save(Category.builder().category("all").build());
        var importantCategory = categoryRepository.save(Category.builder().category("important").build());

        for (int i = 0; i < 10; i++) {
            var task = Task.builder().details("lorem ipsum dolor").build();
            allCategory.addTasks(task);
            taskRepository.save(task);
        }

        for (int i = 0; i < 10; i++) {
            var task = Task.builder().details("lorem ipsum dolor").build();
            importantCategory.addTasks(task);
            taskRepository.save(task);
        }

        categoryRepository.saveAll(List.of(allCategory,importantCategory));
    }
}

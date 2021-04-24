package ir.equadesign.todoapp.bootstrap;

import ir.equadesign.todoapp.domain.Task;
import ir.equadesign.todoapp.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("h2")
@Component
@RequiredArgsConstructor
public class H2Initializer implements CommandLineRunner {

    private final TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {


        for (int i = 0; i < 30; i++) {
            var task = Task.builder().details("lorem ipsum dolor").isDone(false).build();
            taskRepository.save(task);
        }

    }
}

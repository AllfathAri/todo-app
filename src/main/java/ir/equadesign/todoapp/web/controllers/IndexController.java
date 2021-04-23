package ir.equadesign.todoapp.web.controllers;

import ir.equadesign.todoapp.repositories.CategoryRepository;
import ir.equadesign.todoapp.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping({"/", "", "index", "/index.html"})
public class IndexController {

    private final TaskRepository taskRepository;

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("index").addObject("tasks", taskRepository.findAll());
    }
}

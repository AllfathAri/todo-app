package ir.equadesign.todoapp.web.controllers;

import ir.equadesign.todoapp.repositories.CategoryRepository;
import ir.equadesign.todoapp.repositories.TaskRepository;
import ir.equadesign.todoapp.services.TaskService;
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

    private final TaskService taskService;

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("index").addObject("tasks", taskService.findAll());
    }
}

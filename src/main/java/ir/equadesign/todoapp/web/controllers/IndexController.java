package ir.equadesign.todoapp.web.controllers;

import ir.equadesign.todoapp.services.TaskService;
import ir.equadesign.todoapp.web.commands.TaskCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping({"/", "", "index","/index", "/index.html"})
public class IndexController {

    private final TaskService taskService;

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("index")
                .addObject("tasks", taskService.findAll())
                .addObject("task",new TaskCommand());
    }

    @GetMapping("/delete/{taskId}")
    public String deleteTask(@PathVariable String taskId){
        taskService.deleteTask(Integer.valueOf(taskId));
        return "redirect:/index";
    }

    @GetMapping("/undone/{taskId}")
    public String undoneTask(@PathVariable String taskId){
        taskService.markAsUnDone(Integer.valueOf(taskId));
        return "redirect:/index";
    }

    @GetMapping("/done/{taskId}")
    public String doTask(@PathVariable String taskId){
        taskService.markAsDone(Integer.valueOf(taskId));
        return "redirect:/index";
    }

    @PostMapping("createTask")
    public String createTask(@Valid @ModelAttribute("task") TaskCommand taskCommand, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "redirect:/index";
        taskService.createTaskCommand(taskCommand);
        return "redirect:/index";
    }
}

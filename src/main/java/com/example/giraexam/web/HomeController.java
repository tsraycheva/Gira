package com.example.giraexam.web;

import com.example.giraexam.model.view.TaskViewModel;
import com.example.giraexam.service.TaskService;
import com.example.giraexam.service.UserService;
import com.example.giraexam.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final UserService userService;
    private final TaskService taskService;

    public HomeController(CurrentUser currentUser, UserService userService, TaskService taskService) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping()
    public String index(Model model) {
        if(currentUser.isAnonymous()) {
            return "index";
        }


        List<TaskViewModel> tasks = taskService.findAllTasksOrderByDueDate();
        model.addAttribute("tasks", tasks);
//
        return "home";
    }
}

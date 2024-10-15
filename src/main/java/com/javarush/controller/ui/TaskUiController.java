package com.javarush.controller.ui;

import com.javarush.model.enums.Status;
import com.javarush.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskUiController {

    private final TaskService taskService;


    @GetMapping
    public ModelAndView getTasks(ModelAndView modelAndView,
                                 @RequestParam(defaultValue = "0", required = false, name = "page") int page,
                                 @RequestParam(defaultValue = "10", required = false, name = "size") int size) {
        modelAndView.setViewName("tasks");
        var result = taskService.getAllTasks(page, size);
        modelAndView.addObject("page", result);
        modelAndView.addObject("statuses", Status.values());

        return modelAndView;
    }
}

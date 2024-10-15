package com.javarush.controller.rest;

import com.javarush.model.command.TaskCommand;
import com.javarush.model.dto.PageDTO;
import com.javarush.model.dto.TaskDto;
import com.javarush.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskRestController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<PageDTO<TaskDto>> getTasks(@RequestParam(defaultValue = "0", required = false, name = "page") int page,
                                                     @RequestParam(defaultValue = "10", required = false, name = "size") int size) {
        return ResponseEntity.ok(taskService.getAllTasks(page, size));
    }

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody TaskCommand taskCommand) {
        taskService.createTask(taskCommand);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable(name = "id") Long id, @RequestBody TaskCommand taskCommand) {
        var result = taskService.updateTask(id, taskCommand);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable(name = "id") Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}

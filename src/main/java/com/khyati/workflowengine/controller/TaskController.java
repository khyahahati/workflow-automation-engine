package com.khyati.workflowengine.controller;

import com.khyati.workflowengine.domain.Task;
import com.khyati.workflowengine.service.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }

    @PutMapping("/{id}/status")
    public Task updateTaskStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {
        return taskService.updateTaskStatus(id, status);
    }
}

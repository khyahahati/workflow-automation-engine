package com.khyati.workflowengine.service;

import org.springframework.stereotype.Service;
import com.khyati.workflowengine.domain.Task;
import com.khyati.workflowengine.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task updateTaskStatus(Long id, String status) {
        Task task = getTask(id);
        task.setStatus(status);
        return taskRepository.save(task);
    }
}

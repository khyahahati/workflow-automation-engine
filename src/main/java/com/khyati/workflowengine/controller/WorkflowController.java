package com.khyati.workflowengine.controller;

import com.khyati.workflowengine.domain.Workflow;
import com.khyati.workflowengine.domain.Task;
import com.khyati.workflowengine.service.WorkflowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workflows")
public class WorkflowController {

    private final WorkflowService workflowService;

    public WorkflowController(WorkflowService workflowService) {
        this.workflowService = workflowService;
    }

    @PostMapping
    public Workflow createWorkflow(@RequestBody Workflow workflow) {
        return workflowService.createWorkflow(workflow);
    }

    @GetMapping("/{id}")
    public Workflow getWorkflow(@PathVariable Long id) {
        return workflowService.getWorkflow(id);
    }

    @GetMapping
    public List<Workflow> getAll() {
        return workflowService.getAllWorkflows();
    }

    @PostMapping("/{workflowId}/tasks")
    public Workflow addTaskToWorkflow(
            @PathVariable Long workflowId,
            @RequestBody Task task
    ) {
        return workflowService.addTaskToWorkflow(workflowId, task);
    }

    @PutMapping("/{id}/status")
    public Workflow updateStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {
        return workflowService.updateWorkflowStatus(id, status);
    }
}

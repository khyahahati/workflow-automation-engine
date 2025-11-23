package com.khyati.workflowengine.service;

import org.springframework.stereotype.Service;
import com.khyati.workflowengine.domain.Workflow;
import com.khyati.workflowengine.domain.Task;
import com.khyati.workflowengine.repository.WorkflowRepository;

import java.util.List;

@Service
public class WorkflowService {

    private final WorkflowRepository workflowRepository;

    public WorkflowService(WorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }

    public Workflow createWorkflow(Workflow workflow) {
        workflow.setStatus("ACTIVE");
        return workflowRepository.save(workflow);
    }

    public Workflow getWorkflow(Long id) {
        return workflowRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workflow not found"));
    }

    public List<Workflow> getAllWorkflows() {
        return workflowRepository.findAll();
    }

    public Workflow addTaskToWorkflow(Long workflowId, Task task) {
        Workflow workflow = getWorkflow(workflowId);
        workflow.addTask(task);  // This sets bidirectional mapping
        return workflowRepository.save(workflow);
    }

    public Workflow updateWorkflowStatus(Long workflowId, String status) {
        Workflow workflow = getWorkflow(workflowId);
        workflow.setStatus(status);
        return workflowRepository.save(workflow);
    }
}

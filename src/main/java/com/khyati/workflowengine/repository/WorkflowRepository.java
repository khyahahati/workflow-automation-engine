package com.khyati.workflowengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.khyati.workflowengine.domain.Workflow;

@Repository
public interface WorkflowRepository extends JpaRepository<Workflow, Long> {

}

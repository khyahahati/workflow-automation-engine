package com.khyati.workflowengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.khyati.workflowengine.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}

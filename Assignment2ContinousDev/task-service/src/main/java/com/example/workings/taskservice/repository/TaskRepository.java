package com.example.workings.taskservice.repository;

import com.chanaka.workings.commons.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}

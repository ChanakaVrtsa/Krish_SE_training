package com.example.workings.taskservice.service;

import com.chanaka.workings.commons.model.Task;
import com.example.workings.taskservice.model.ProjectDetailedResponse;

import java.util.List;

public interface TaskService {

    Task save(Task task);

    Task getTaskById(int id);

    ProjectDetailedResponse getProjectDetailedResponse(int id);

    List<Task> getAllTasks();

    String deleteTaskById(int id);

    Task updateTaskById(int id, Task task);
}

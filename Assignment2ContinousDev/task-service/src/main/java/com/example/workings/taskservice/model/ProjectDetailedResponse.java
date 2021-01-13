package com.example.workings.taskservice.model;

import com.chanaka.workings.commons.model.Project;
import com.chanaka.workings.commons.model.Task;

public class ProjectDetailedResponse implements Response{

    Task task;
    Project project;

    public ProjectDetailedResponse(Task task, Project project) {
        this.task = task;
        this.project = project;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}

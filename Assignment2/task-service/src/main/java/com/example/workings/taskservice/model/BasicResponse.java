package com.example.workings.taskservice.model;

import com.chanaka.workings.commons.model.Task;

public class BasicResponse implements Response{

    Task task;

    public BasicResponse(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}

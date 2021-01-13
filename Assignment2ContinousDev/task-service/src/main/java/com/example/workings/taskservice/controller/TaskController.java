package com.example.workings.taskservice.controller;

import com.chanaka.workings.commons.model.Task;
import com.example.workings.taskservice.model.BasicResponse;
import com.example.workings.taskservice.model.ProjectDetailedResponse;
import com.example.workings.taskservice.model.Response;
import com.example.workings.taskservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/services/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> save(@RequestBody Task task) {
        try{
            Task tsk = taskService.save(task);
            if(tsk!=null){
                return ResponseEntity.ok().body(task);
            }else {
                return ResponseEntity.notFound().build();
            }
        } catch (HttpClientErrorException httpClientErrorException){
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Response> fetch(@PathVariable int id, @RequestParam(required = false) String type) {
        if(type!=null) {
            if(type.equals("all")) {
                //if user has entered all as a string; return this
                ProjectDetailedResponse projectDetailedResponse = taskService.getProjectDetailedResponse(id);
                if(projectDetailedResponse!=null){
                    return ResponseEntity.ok().body(projectDetailedResponse);
                }else {
                    return ResponseEntity.notFound().build();
                }
            }else {
                //if user has entered a non matching string
                Task task = taskService.getTaskById(id);
                if(task!=null) {
                    BasicResponse basicResponse = new BasicResponse(task);
                    return ResponseEntity.ok().body(basicResponse);
                }
                return ResponseEntity.notFound().build();
            }
        }else {
            //if user has not entered any string
            Task task = taskService.getTaskById(id);
            if(task!=null) {
                BasicResponse basicResponse = new BasicResponse(task);
                return ResponseEntity.ok().body(basicResponse);
            }
            return ResponseEntity.notFound().build();
       }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        try{
            String result = taskService.deleteTaskById(id);
            return ResponseEntity.ok().body(result);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Task> update(@PathVariable int id, @RequestBody Task task) {
        try{
            Task tsk = taskService.updateTaskById(id,task);
            if(tsk!=null){
                return ResponseEntity.ok().body(task);
            }else {
                return ResponseEntity.notFound().build();
            }
        } catch (HttpClientErrorException httpClientErrorException){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Task> fetchAll() {
        return taskService.getAllTasks();
    }
}

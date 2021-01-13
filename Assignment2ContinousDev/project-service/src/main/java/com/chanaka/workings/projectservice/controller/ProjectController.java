package com.chanaka.workings.projectservice.controller;

import com.chanaka.workings.commons.model.Project;
import com.chanaka.workings.projectservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/services/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping
    public Project save(@RequestBody Project project) {
        return projectService.save(project);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Project> fetch(@PathVariable int id) {
        try {
            Project project = projectService.getProjectById(id);
            return ResponseEntity.ok().body(project);
        }catch (NoSuchElementException noSuchElementException) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        try{
            String result = projectService.deleteProjectById(id);
            return ResponseEntity.ok().body(result);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping
    public List<Project> fetchAll() {
        return projectService.getAllProjects();
    }
}

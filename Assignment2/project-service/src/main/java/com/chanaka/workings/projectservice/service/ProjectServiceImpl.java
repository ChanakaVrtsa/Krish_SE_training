package com.chanaka.workings.projectservice.service;

import com.chanaka.workings.commons.model.Project;
import com.chanaka.workings.projectservice.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    ProjectRepository projectRepository;

    //save method saves project object in database by passing into repository class
    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    //retrieves project info by passing project id as a parameter
    @Override
    public Project getProjectById(int id) {
        //Optional is used to avoid null pointer exceptions
        Optional<Project> project = projectRepository.findById(id);

        return project.get();

    }

    //deletes project by passing id as a parameter
    @Override
    public String deleteProjectById(int id) {
        projectRepository.deleteById(id);

        return "Project Deleted Successfully";
    }

    //returns all projects
    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }


}

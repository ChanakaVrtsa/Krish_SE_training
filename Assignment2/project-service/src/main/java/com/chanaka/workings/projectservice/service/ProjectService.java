package com.chanaka.workings.projectservice.service;

import com.chanaka.workings.commons.model.Project;

import java.util.List;

public interface ProjectService {

    Project save(Project project);

    Project getProjectById(int id);

    String deleteProjectById(int id);

    List<Project> getAllProjects();
}

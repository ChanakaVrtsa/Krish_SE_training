package com.chanaka.workings.projectservice.repository;

import com.chanaka.workings.commons.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {

}

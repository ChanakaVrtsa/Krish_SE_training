package com.example.workings.taskservice.hystrix;

import com.chanaka.workings.commons.model.Project;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

public class ProjectCommand extends HystrixCommand<Project> {

    RestTemplate restTemplate;
    int projectId;

    public ProjectCommand(RestTemplate restTemplate, int projectId){

        super(HystrixCommandGroupKey.Factory.asKey("default"));
        this.restTemplate = restTemplate;
        this.projectId = projectId;

    }

    @Override
    protected Project run() throws Exception {
        return restTemplate.getForObject("http://project/services/projects/"+projectId,Project.class);
    }

    @Override
    protected Project getFallback() {
        return new Project();
    }
}

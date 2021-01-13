package com.example.workings.taskservice.service;

import com.chanaka.workings.commons.model.Project;
import com.chanaka.workings.commons.model.Task;
import com.example.workings.taskservice.model.ProjectDetailedResponse;
import com.example.workings.taskservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    RestTemplate restTemplate;

    //save method saves task object in database by passing into repository class
    @Override
    public Task save(Task task) {
        //gets project object from project service
        //passes task's project id as a parameter
        Project project =getProject(task.getProjectId());
            //if project is ongoing or not started; adds task to database
            if(project.getProgress().equals("ongoing") || project.getProgress().equals("not started")) {
                return taskRepository.save(task);
            }else {
                return null;
            }
    }

    @Override
    public Task getTaskById(int id) {
        //Optional is used to avoid null pointer execptions
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()) {
            //returns if a match is found
            return task.get();
        }
        return null;
    }

    //returns two objects(task,project) as a return
    //can be used to chain two services
    @Override
    public ProjectDetailedResponse getProjectDetailedResponse(int id) {
        //gets task object by passing id
        Task task = getTaskById(id);
        if(task!=null) {
            //gets project object through a rest template by passing project id parameter received from task
            Project project =getProject(task.getProjectId());
            return new ProjectDetailedResponse(task,project);
        } else {
            return null;
        }
    }

    @Override
    public String deleteTaskById(int id) {
        //if found deletes the entry
        taskRepository.deleteById(id);
        return "Project Deleted Successfully";
    }

    @Override
    public Task updateTaskById(int id, Task task) {
        Task previousTask = getTaskById(id);
        //updates previous tasks properties by values passed from user
        if(previousTask!=null) {
            previousTask.setName(task.getName());
            previousTask.setDuration(task.getDuration());
            previousTask.setTaskAssignee(task.getTaskAssignee());
            previousTask.setProgress(task.getProgress());
            previousTask.setProjectId(task.getProjectId());
            //saves only if project is running or not started
            //else returns null
            return save(previousTask);
        }
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    private Project getProject(int projectId) {
        return restTemplate.getForObject("http://localhost:9191/services/projects/"+projectId,Project.class);
    }
}

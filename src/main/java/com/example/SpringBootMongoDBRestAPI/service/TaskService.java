package com.example.SpringBootMongoDBRestAPI.service;

import com.example.SpringBootMongoDBRestAPI.model.Task;
import com.example.SpringBootMongoDBRestAPI.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class TaskService {
    private final TaskRepository repository;


    @Autowired
    TaskService(TaskRepository repository){
        this.repository = repository;
    }

    // CRUD - Create, read, update, delete

    // CREATE
    public Task addTask(Task task){
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);

        return repository.save(task);
    }

    // READ

    public List<Task> findAllTasks(){
        return repository.findAll();
    }
    public Task getTaskById(String taskId){
        return repository.findById(taskId).get();
    }



    public List<Task> getTaskBySeverity(Integer severity){

        return repository.findBySeverity(severity);

    }

    public List<Task> getTaskByAssignee(String assignee){


        return repository.getTaskByAssignee(assignee);
    }


    // UPDATE

    public Task updateTask(Task taskRequest){


        Task existingTask = repository.findById(taskRequest.getTaskId()).get();
        existingTask.setAssignee(taskRequest.getAssignee());
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setSeverity(taskRequest.getSeverity());
        existingTask.setStoryPoint(taskRequest.getStoryPoint());

        return repository.save(existingTask);

    }

    // DELETE

    public String deleteTask(String taskID){
        repository.deleteById(taskID);
        return "TaskID is deleted: "+taskID;
    }


}

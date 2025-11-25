package com.example.demo.domain.services.impl;

import com.example.demo.domain.entities.TaskList;
import com.example.demo.domain.repository.TaskListRepository;
import com.example.demo.domain.services.TaskListService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskList> listTaskList() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(TaskList taskList){
        if(null != taskList.getId()){
            throw new IllegalArgumentException("Task list already has an id !");
        }
        if(null == taskList.getTitle()){
            throw new IllegalArgumentException("Task list title is null !");
        }
        LocalDateTime now = LocalDateTime.now();
        return taskListRepository.save(new TaskList(
                null,
                taskList.getTitle(),
                taskList.getDescription(),
                null,
                now,
                now
        ));

    }

    @Override
    public Optional<TaskList> getTaskList(UUID id) {
        return taskListRepository.findById(id);
    }

    @Override
    public TaskList updateTaskList(UUID taskListId, TaskList taskList) {
        if(null == taskList.getId()){
            throw new IllegalArgumentException("Task list must have an id !");
        }
        if(!Objects.equals(taskList.getId(), taskListId)){
            throw new IllegalArgumentException("Attending to change teh task list ID , that is not permited !");
        }

        TaskList existingTaskList =  taskListRepository.findById(taskListId).orElseThrow(() ->
                new IllegalArgumentException("Task list id not found !"));
        existingTaskList.setTitle(taskList.getTitle());
        existingTaskList.setDescription(taskList.getDescription());
        existingTaskList.setUpdated(LocalDateTime.now());
        return taskListRepository.save(existingTaskList);


    }

    @Override
    public void deleteTaskList(UUID id) {
        if(null == id){
            throw new IllegalArgumentException("Task list must have an id !");
        }
        if(taskListRepository.existsById(id)){
            taskListRepository.deleteById(id);
        }
    }

}

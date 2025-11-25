package com.example.demo.domain.controller;

import com.example.demo.domain.dto.TaskDto;
import com.example.demo.domain.entities.Task;
import com.example.demo.domain.mappers.TaskMapper;
import com.example.demo.domain.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path= "/api/task-lists/{task_list_id}/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping
    public List<TaskDto> getTasks(@PathVariable("task_list_id") UUID taskListiId) {
        return taskService.listTasks(taskListiId)
                .stream().map(taskMapper::toDto)
                .toList();
    }

    @PostMapping
    public TaskDto createTask(
            @PathVariable("task_list_id")  UUID taskListId,
            @RequestBody TaskDto taskDto) {
        Task createdTask = taskService.createTask(taskListId, taskMapper.fromDto(taskDto)
        );
        return taskMapper.toDto(createdTask);
    }


}

package com.example.demo.domain.controller;

import com.example.demo.domain.dto.TaskListDto;
import com.example.demo.domain.entities.TaskList;
import com.example.demo.domain.mappers.TaskListMapper;
import com.example.demo.domain.repository.TaskListRepository;
import com.example.demo.domain.services.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/task-lists")
public class TaskListController {
    private TaskListService taskListService;
    private TaskListMapper taskListMapper;

    TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }


    @GetMapping()
    public List<TaskListDto> listTaskList() {
        return taskListService.listTaskList()
                .stream().map(taskListMapper::toDto)
                .toList();

    }

    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto) {
        TaskList createdtasklist = taskListService.createTaskList(
                taskListMapper.fromDto(taskListDto)
        );
        return taskListMapper.toDto(createdtasklist);
    }

    @GetMapping("/{task_list_id}")
    public Optional<TaskListDto> getTaskList(@PathVariable("task_list_id") UUID taskListiId) {
        return taskListService.getTaskList(taskListiId)
                .map(taskListMapper::toDto);
    }

    @PutMapping("/{task_list_id}")
    public TaskListDto updateTaskList(
            @PathVariable("task_list_id") UUID taskListiId,
            @RequestBody TaskListDto taskListDto
    ){

        TaskList updatedTaskList =  taskListService.updateTaskList(taskListiId,taskListMapper.fromDto(taskListDto));
        return taskListMapper.toDto(updatedTaskList);
    }

    @DeleteMapping("/{task_list_id}")
    public void deleteTaskList(@PathVariable("task_list_id") UUID taskListiId) {
        taskListService.deleteTaskList(taskListiId);
    }

}

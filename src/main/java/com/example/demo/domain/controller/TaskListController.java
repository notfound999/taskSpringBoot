package com.example.demo.domain.controller;

import com.example.demo.domain.dto.TaskListDto;
import com.example.demo.domain.entities.TaskList;
import com.example.demo.domain.mappers.TaskListMapper;
import com.example.demo.domain.repository.TaskListRepository;
import com.example.demo.domain.services.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/task-list")
public class TaskListController {
    private TaskListService taskListService;
    private TaskListMapper taskListMapper;

    TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }


    @GetMapping
    public List<TaskListDto> listTaskList() {
        return taskListService.listTaskList()
                .stream().map(taskListMapper::toDto)
                .toList();

    }
}

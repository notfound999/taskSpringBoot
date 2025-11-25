package com.example.demo.domain.services.impl;

import com.example.demo.domain.entities.TaskList;
import com.example.demo.domain.repository.TaskListRepository;
import com.example.demo.domain.services.TaskListService;
import org.springframework.stereotype.Service;

import java.util.List;
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
}

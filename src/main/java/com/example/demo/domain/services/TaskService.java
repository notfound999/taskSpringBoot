package com.example.demo.domain.services;

import com.example.demo.domain.entities.Task;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    List<Task> listTasks(UUID taskListiId);

    Task createTask(UUID taskListId ,Task task);



}

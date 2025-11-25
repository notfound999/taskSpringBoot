package com.example.demo.domain.services.impl;

import com.example.demo.domain.entities.Task;
import com.example.demo.domain.entities.TaskList;
import com.example.demo.domain.entities.TaskPriority;
import com.example.demo.domain.entities.TaskStatus;
import com.example.demo.domain.repository.TaskListRepository;
import com.example.demo.domain.repository.TaskRepository;
import com.example.demo.domain.services.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskListRepository taskListRepository;
    private final TaskRepository taskRepository;
    public TaskServiceImpl(TaskRepository taskRepository , TaskListRepository taskListRepository) {
        this.taskRepository = taskRepository;
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<Task> listTasks(UUID taskListiId) {
        if(taskListiId == null){
            throw new NullPointerException("taskListiId shouldnt be null");
        }
        return  taskRepository.findByTasklistId(taskListiId);
    }

    @Override
    public Task createTask(UUID taskListId ,Task task) {
        if(task.getId() != null){
            throw new NullPointerException("id shouldnt be null");
        }
        if(task.getTitle() == null){
            throw new NullPointerException("title shouldnt be null");
        }

        LocalDateTime now = LocalDateTime.now();
        TaskPriority taskPriority = Optional.ofNullable(task.getPriority()).orElse(TaskPriority.LOW);
        TaskStatus taskStatus = Optional.ofNullable(task.getStatus()).orElse(TaskStatus.OPEN);
        TaskList taskList = taskListRepository.findById(taskListId).orElseThrow(() -> new NullPointerException("tasklist not found"));
        return taskRepository.save(new Task(
                null,
                task.getTitle(),
                task.getDescription(),
                taskStatus,
                task.getDuedate(),
                taskPriority,
                taskList,
                now,
                now
        ));


    }
}

package com.example.demo.domain.mappers.impl;

import com.example.demo.domain.dto.TaskDto;
import com.example.demo.domain.entities.Task;
import com.example.demo.domain.mappers.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {


    @Override
    public Task fromDto(TaskDto taskdto) {
        return new Task(
                taskdto.id(),
                taskdto.title(),
                taskdto.description(),
                taskdto.status(),
                taskdto.dueDate(),
                taskdto.priority(),
                null,
                null,
                null

        );
    }

    @Override
    public TaskDto fromEntity(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDuedate(),
                task.getPriority(),
                task.getStatus()
        );
    }
}

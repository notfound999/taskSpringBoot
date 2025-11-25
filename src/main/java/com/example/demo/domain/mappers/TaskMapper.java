package com.example.demo.domain.mappers;

import com.example.demo.domain.dto.TaskDto;
import com.example.demo.domain.entities.Task;

public interface TaskMapper {
    Task fromDto(TaskDto taskdto);

    TaskDto toDto(Task task);
}

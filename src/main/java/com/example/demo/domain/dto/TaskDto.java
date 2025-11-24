package com.example.demo.domain.dto;

import com.example.demo.domain.entities.TaskPriority;
import com.example.demo.domain.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status
) {

}

package com.example.demo.domain.mappers;

import com.example.demo.domain.dto.TaskListDto;
import com.example.demo.domain.entities.TaskList;

import java.util.List;

public interface TaskListMapper {
    public TaskList fromDto(TaskListDto taskListDto);

    public TaskListDto toDto (TaskList taskList);
}

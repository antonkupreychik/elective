package com.javarush.service;

import com.javarush.model.command.TaskCommand;
import com.javarush.model.dto.PageDTO;
import com.javarush.model.dto.TaskDto;

public interface TaskService {

    PageDTO<TaskDto> getAllTasks(Integer page, Integer pageSize);

    void createTask(TaskCommand taskCommand);

    TaskDto updateTask(Long id, TaskCommand taskCommand);

    void deleteTask(Long id);
}

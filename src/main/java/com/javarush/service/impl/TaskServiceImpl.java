package com.javarush.service.impl;

import com.javarush.exceptions.ObjectNotFoundException;
import com.javarush.mapper.TaskMapper;
import com.javarush.model.command.TaskCommand;
import com.javarush.model.dto.PageDTO;
import com.javarush.model.dto.TaskDto;
import com.javarush.repository.TaskRepository;
import com.javarush.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public PageDTO<TaskDto> getAllTasks(Integer page, Integer pageSize) {
        log.info("Getting all tasks with page {} and page size {}", page, pageSize);
        var pageable = PageRequest.of(page, pageSize);
        var pageResult = taskRepository.findAll(pageable);
        var resultList = pageResult
                .stream()
                .map(taskMapper::toDto)
                .toList();
        return new PageDTO<>(resultList, pageable, pageResult);
    }

    @Override
    @Transactional
    public void createTask(TaskCommand taskCommand) {
        log.info("Saving task: {}", taskCommand);
        var taskToSave = taskMapper.toTask(taskCommand);
        taskRepository.save(taskToSave);
    }

    @Override
    @Transactional
    public TaskDto updateTask(Long id, TaskCommand taskCommand) {
        log.info("Updating task with id: {}", id);
        var task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            log.error("Task with id {} not found", id);
            throw new ObjectNotFoundException("Task with id " + id + " not found");
        }
        task = taskMapper.toTask(taskCommand, task);
        taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    @Override
    @Transactional
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}

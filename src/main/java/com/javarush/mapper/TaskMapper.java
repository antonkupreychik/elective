package com.javarush.mapper;

import com.javarush.model.command.TaskCommand;
import com.javarush.model.dto.TaskDto;
import com.javarush.model.entities.Task;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskMapper {

    TaskDto toDto(Task task);

    Task toTask(TaskCommand taskCommand);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Task toTask(TaskCommand taskCommand, @MappingTarget Task tag);
}

package com.javarush.model.command;

import com.javarush.model.enums.Status;
import lombok.Data;

@Data
public class TaskCommand {
    private String description;
    private Status status;
}

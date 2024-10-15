package com.javarush.model.dto;

import com.javarush.model.enums.Status;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto  {
    private Long id;
    private String description;
    private Status status;
}
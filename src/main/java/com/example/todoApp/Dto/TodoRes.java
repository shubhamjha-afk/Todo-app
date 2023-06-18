package com.example.todoApp.Dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TodoRes {
    private String title;
    private String description;
    private String status;
    private String priority;
    private LocalDateTime dueDate;

}

package com.example.todoApp.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column()
    private String status;

    @Column()
    private String priority;

    @Column
    private LocalDateTime dueDate;

    @Column( columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdDate;

    @Column( columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime modifiedDate;
    @Column(name = "is_delete")
    private Boolean isDelete;

//    @Column
//    private Long userId; // If applicable

//    @Column
//    private String category; // If applicable

//    @Column
//    private String attachment; // If applicable

    // Constructors (including default and parameterized constructors)



    // Getters and Setters (omitted for brevity)

    // Add any additional methods or relationships as needed
}

package com.example.todoApp.Dao;

import com.example.todoApp.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Todo,Integer> {

    Todo findById(int id);
}

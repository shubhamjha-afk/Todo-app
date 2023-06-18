package com.example.todoApp.Service;

import com.example.todoApp.Dto.TodoReq;
import com.example.todoApp.Dto.TodoRes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {

    TodoRes additem(TodoReq todoReq);
    List<TodoRes> getAllItem();

    TodoRes getItem(int id);

    void deleteItem(int id);

    TodoRes updateItem(TodoReq todoReq, int id);
}

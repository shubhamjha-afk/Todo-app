package com.example.todoApp.Service;

import com.example.todoApp.Dao.TodoRepo;
import com.example.todoApp.Dto.TodoReq;
import com.example.todoApp.Dto.TodoRes;
import com.example.todoApp.Entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepo repo;

    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());



    private LocalDateTime dateTimeConv(String timeStamp){
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime dateTime = LocalDateTime.parse(timeStamp, inputFormatter);

        return dateTime;
    }
    private Todo mapingReqToEntity(TodoReq todoReq,Integer id){
        Todo todo=new Todo();
        if (id==null) {
            todo.setTitle(todoReq.getTitle());
            todo.setDescription(todoReq.getDescription());
            todo.setPriority(todoReq.getPriority());
            todo.setDueDate(todoReq.getDueDate());
            todo.setStatus(todoReq.getStatus());

            todo.setCreatedDate(dateTimeConv(timeStamp));
            todo.setModifiedDate(dateTimeConv(timeStamp));
            return todo;
        }else{
            Todo byId=repo.getById(id);
            byId.setTitle(todoReq.getTitle());
            byId.setDescription(todoReq.getDescription());
            byId.setPriority(todoReq.getPriority());
            byId.setDueDate(todoReq.getDueDate());
            byId.setStatus(todoReq.getStatus());
            byId.setModifiedDate(dateTimeConv(timeStamp));
            return byId;
        }



    }
    private TodoRes mapingEntityToRes(Todo todo){
        TodoRes todores=new TodoRes();
        todores.setTitle(todo.getTitle());
        todores.setDescription(todo.getDescription());
        todores.setPriority(todo.getPriority());
        todores.setDueDate(todo.getDueDate());
        todores.setStatus(todo.getStatus());
        return todores;
    }

    @Override
    public TodoRes additem(TodoReq todoReq)throws RuntimeException {
        Todo todo = repo.saveAndFlush(mapingReqToEntity(todoReq, null));
        TodoRes todoRes=new TodoRes();
        return (mapingEntityToRes(todo));

    }

    @Override
    public List<TodoRes> getAllItem() {
      List<Todo> todos= repo.findAll();
      List<TodoRes>todoRes=new ArrayList<>();
        for (Todo todo:todos) {
            todoRes.add(mapingEntityToRes(todo));
        }

      return todoRes;
    }

    @Override
    public void deleteItem(int id) {
        Todo todo =repo.findById(id);
        todo.setIsDelete(true);
        repo.saveAndFlush(todo);

    }

    @Override
    public TodoRes updateItem(TodoReq todoReq, int id) {
        Todo save = repo.save(mapingReqToEntity(todoReq, id));
        TodoRes res=new TodoRes();
        return mapingEntityToRes(save);

    }

    @Override
    public TodoRes getItem(int id)throws RuntimeException {
        Todo todo=new Todo();
         todo = repo.findById(id);
        return mapingEntityToRes(todo);
    }
}

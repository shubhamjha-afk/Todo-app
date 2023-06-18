package com.example.todoApp.Controller;

import com.example.todoApp.Dto.TodoReq;
import com.example.todoApp.Dto.TodoRes;
import com.example.todoApp.Service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TodoController {
    private static Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    TodoService service;

    @PostMapping("tasks")
    public ResponseEntity<TodoRes> addItem(@RequestBody TodoReq todoReq){
        try {
            logger.info("insise controller :: Add tasks");
            return new ResponseEntity<>(service.additem(todoReq), HttpStatus.CREATED);

        } catch (Exception e){
            logger.error(String.valueOf(e));
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("items")
    public ResponseEntity<List<TodoRes>>getAllItem(){
        try {
            logger.error("Inside controller :: getAllItem ");
            return new ResponseEntity<>(service.getAllItem(),HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("items/{id}")
    public ResponseEntity<TodoRes>getItem(@PathVariable int id){
        try {
            logger.error("Inside controller :: getItem ");
            return new ResponseEntity<>(service.getItem(id),HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("items/{id}")
    public ResponseEntity<HttpStatus>deleteItem(@PathVariable int id){
        try {
            logger.error("Inside controller :: DeleteItem ");
            service.deleteItem(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping("updateitem/{id}")
    public ResponseEntity<TodoRes> updateItem(@RequestBody TodoReq todoReq,@PathVariable int id){
        try {
            logger.error("Inside controller :: updateItem ");
            return new ResponseEntity<>(service.updateItem(todoReq,id), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}

package com.todos.todoApp.controller;

import com.todos.todoApp.entity.TodoEntity;
import com.todos.todoApp.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping({"/","/home"})
    public List<TodoEntity> findAll(){
        return todoService.findAll();
    }

    @PostMapping("/add")
    public TodoEntity addTodo(@RequestBody TodoEntity todo){
        return todoService.addTodo(todo);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TodoEntity> updateTodo(@PathVariable Long id, @RequestBody TodoEntity updatedTodo){
        return todoService.updateTodo(id, updatedTodo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id){
        if(todoService.deleteTodo(id)) {
            return ResponseEntity.ok("Todo deleted successfully..");
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo not found");
    }
}


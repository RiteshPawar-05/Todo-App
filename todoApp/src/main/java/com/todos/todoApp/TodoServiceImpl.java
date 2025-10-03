package com.todos.todoApp;

import com.todos.todoApp.entity.TodoEntity;
import com.todos.todoApp.repository.TodoRepository;
import com.todos.todoApp.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<TodoEntity> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public TodoEntity addTodo(TodoEntity todo) {
        todo.setCompleted(false);
        return todoRepository.save(todo);
    }

    @Override
    public Optional<TodoEntity> updateTodo(Long id, TodoEntity updateEntity) {
        return todoRepository.findById(id).map(todo ->{
            todo.setTitle(updateEntity.getTitle());
            return todoRepository.save(todo);
        });
    }

    @Override
    public boolean deleteTodo(Long id) {
        if(todoRepository.existsById(id)){
            todoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

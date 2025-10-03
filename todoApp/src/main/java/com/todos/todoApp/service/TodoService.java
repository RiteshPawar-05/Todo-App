package com.todos.todoApp.service;


import com.todos.todoApp.TodoServiceImpl;
import com.todos.todoApp.entity.TodoEntity;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<TodoEntity> findAll();
    TodoEntity addTodo(TodoEntity todo);
    Optional<TodoEntity> updateTodo(Long id, TodoEntity updateEntity);
    boolean deleteTodo(Long id);
}

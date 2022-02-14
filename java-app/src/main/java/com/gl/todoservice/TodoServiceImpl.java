package com.gl.todoservice;

import java.util.List;

public class TodoServiceImpl {
    TodoService todoService;

    public TodoServiceImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    List<String> retrieveRelatedTodos(String user) {
        System.out.println("retrieveRelatedTodos() user = " + user);
        return todoService.retrieveTodos(user);
    }
}

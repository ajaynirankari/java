package com.gl.todoservice;

import java.util.List;

public class TodoServiceStub implements TodoService {
    @Override
    public List<String> retrieveTodos(String user) {
        return List.of("Learning MVC", "Learning Spring", "Learning Dance");
    }
}

package com.gl.todoservice;

import java.util.List;

interface TodoService {
    List<String> retrieveTodos(String user);
}

package com.gl.todoservice;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TodoServiceStubTest extends TestCase {

    @Test
    public void testRetrieveRelatedTodosUsingStub()
    {
        TodoService todoService=new TodoServiceStub();
        TodoServiceImpl service = new TodoServiceImpl(todoService);
        List<String> relatedTodos = service.retrieveRelatedTodos("dummy");
        assertEquals(3,relatedTodos.size());
    }

}
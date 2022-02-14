package com.gl.todoservice;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TodoServiceImplMockTest extends TestCase {
    @Test
    public void testRetrieveRelatedTodosUsingMock() {
        TodoService todoService = mock(TodoService.class);
        TodoServiceImpl service = new TodoServiceImpl(todoService);
        List<String> relatedTodos = service.retrieveRelatedTodos("dummy");
        assertEquals(0, relatedTodos.size());
    }

    @Test
    public void testRetrieveRelatedTodosUsingMock_DummyResponse() {
        TodoService todoService = mock(TodoService.class);
        List<String> expectedTodos = List.of("todo1", "todo2");
        when(todoService.retrieveTodos("dummy")).thenReturn(expectedTodos);

        TodoServiceImpl service = new TodoServiceImpl(todoService);
        List<String> relatedTodos = service.retrieveRelatedTodos("dummy");
        assertEquals(expectedTodos.size(), relatedTodos.size());
    }
}
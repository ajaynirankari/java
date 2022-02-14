package com.gl;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class ListTest {
    @Test
    public void testListSize() {
        List list = Mockito.mock(List.class);
        Mockito.when(list.size()).thenReturn(2);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void testListSize_MultipleTime() {
        List list = Mockito.mock(List.class);
        Mockito.when(list.size()).thenReturn(2).thenReturn(3);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(3, list.size());
        Assert.assertEquals(3, list.size());
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void testListGet() {
        List list = Mockito.mock(List.class);
        String expected="zero";
        Mockito.when(list.get(0)).thenReturn(expected);
        Assert.assertEquals(expected, list.get(0));
        Assert.assertEquals(null, list.get(1));
    }

    @Test
    public void testListGetAny() {
        List list = Mockito.mock(List.class);
        String expected="zero";
        Mockito.when(list.get(Mockito.anyInt())).thenReturn(expected);
        Assert.assertEquals(expected, list.get(0));
        Assert.assertEquals(expected, list.get(1));
    }

    @Test(expected = RuntimeException.class)
    public void testListGetThrowException() {
        List list = Mockito.mock(List.class);
        String expected="zero";
        Mockito.when(list.get(-1)).thenThrow(new RuntimeException("It is now allowed"));
        list.get(-1);
    }
}

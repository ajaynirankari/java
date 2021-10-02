package com.gl;

import static org.junit.Assert.*;

import com.gl.primenumber.PrimeNumber;
import org.junit.Test;

public class PrimeNumberTest {

    @Test
    public void isPrimeTrue(){
        assertTrue(PrimeNumber.isPrime(5));
    }
    @Test
    public void isPrimeFalse(){
        assertFalse(PrimeNumber.isPrime(15));
    }
    @Test
    public void first15PrimeNumbers(){
        assertEquals(15,PrimeNumber.primeNumbers(50).size());
    }
}

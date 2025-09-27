package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyFirstTest {

    @Test
    void additionTest() {
        int result = 2 + 3;
        assertEquals(5, result, "2 + 3 should equal 5");
    }

    @Test
    void multiplicationTest() {
        int result = 4 * 5;
        assertEquals(20, result, "4 * 5 should equal 20");
    }
}

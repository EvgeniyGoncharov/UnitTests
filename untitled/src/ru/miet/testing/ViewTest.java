package ru.miet.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    private View view = new View();
    @Test
    void printResult() {

        assertEquals(1.0 , view.printResult(0.1));
    }

    @Test
    void displayError() {
    }

    @Test
    void getFirstArgumentAsString() {
    }

    @Test
    void getSecondArgumentAsString() {
    }
}
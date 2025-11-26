package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for Task class used in To-Do App
 */
public class AppTest {

    //  Test 1: Task should be created with correct title
    @Test
    public void testTaskCreation() {
        Task task = new Task("Complete Assignment");

        assertEquals("Complete Assignment", task.title);
        assertFalse(task.completed);
    }

    //  Test 2: Task should be marked as completed
    @Test
    public void testMarkTaskDone() {
        Task task = new Task("Write JUnit Tests");

        task.markDone();

        assertTrue(task.completed);
    }

    //  Test 3: toString() should show NOT completed format
    @Test
    public void testToStringNotCompleted() {
        Task task = new Task("Buy Milk");

        String expected = "[ ] Buy Milk";
        assertEquals(expected, task.toString());
    }

    //  Test 4: toString() should show COMPLETED format
    @Test
    public void testToStringCompleted() {
        Task task = new Task("Push to GitHub");

        task.markDone();
        String expected = "[✓] Push to GitHub";
        assertEquals(expected, task.toString());
    }
}

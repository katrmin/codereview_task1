package com.yourcodereview.katrmin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1Test {

    @Test
    void perform() {
        Task1 task = new Task1();
        long actual = task.perform("input.txt");
        Assertions.assertEquals(4L, actual);
    }
}
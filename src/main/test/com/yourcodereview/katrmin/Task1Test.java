package com.yourcodereview.katrmin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

class Task1Test {

    @Test
    void perform() throws IOException {
        Task1 task = new Task1();
        long actual = task.perform("input.txt");
        Assertions.assertEquals(4L, actual);
    }

    @Test
    void failPerform() {
        Task1 task = new Task1();
        Assertions.assertThrows(FileNotFoundException.class, () -> task.perform("notExistedFile.txt"));
    }
}
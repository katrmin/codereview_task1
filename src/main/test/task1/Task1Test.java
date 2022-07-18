package task1;

import org.junit.jupiter.api.Assertions;

class Task1Test {

    @org.junit.jupiter.api.Test
    void perform() {
        Task1 task = new Task1();
        long actual = task.perform("input.txt");
        Assertions.assertEquals(4L, actual);
    }
}
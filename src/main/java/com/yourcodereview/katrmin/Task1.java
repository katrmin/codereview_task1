package com.yourcodereview.katrmin;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task1 {
    public static final int ARRAY_SIZE = 1073741824;
    public static final long THIRD_ARRAY_THRESHOLD = ARRAY_SIZE * 3L;
    public static final long SECOND_ARRAY_THRESHOLD = ARRAY_SIZE * 2L;

    private Storage storage;

    //Необходимо всего 4 294 967 296 элементов массива
    public Task1() {
        storage = new Storage();
    }

    public static void main(String @NotNull [] args) {
        System.out.println(args[0]);
        Task1 task = new Task1();
        task.perform(args[0]);
    }

    public long perform(String arg) {
        long count = 0L;
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(arg))) {
            String ipString;
            while ((ipString = reader.readLine()) != null) {
                System.out.println(ipString);
                long parsedNumber = Parser.parseToNumber(ipString);
                storage.putExistenceToArray(parsedNumber);
            }
            count = storage.getExistingElementsCount();
            System.out.printf("Количество уникальных адресов равно: %s%n", count);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}

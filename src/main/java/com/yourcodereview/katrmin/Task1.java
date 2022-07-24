package com.yourcodereview.katrmin;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task1 {
    private Storage storage;

    public Task1() {
        storage = new Storage();
    }

    public static void main(String @NotNull [] args) throws IOException {
        System.out.println(args[0]);
        Task1 task = new Task1();
        task.perform(args[0]);
    }

    public long perform(String arg) throws IOException {
        long count;
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
            throw e;

        }
        return count;
    }
}

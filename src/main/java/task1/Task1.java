package task1;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task1 {
    public static final int ARRAY_SIZE = 1073741824;
    public static final long THIRD_ARRAY_THRESHOLD = ARRAY_SIZE * 3L;
    public static final long SECOND_ARRAY_THRESHOLD = ARRAY_SIZE * 2L;

    private boolean[] readIps1;
    private boolean[] readIps2;
    private boolean[] readIps3;
    private boolean[] readIps4;

    //Необходимо всего 4 294 967 296 элементов массива
    public Task1() {
        readIps1 = new boolean[ARRAY_SIZE];
        readIps2 = new boolean[ARRAY_SIZE];
        readIps3 = new boolean[ARRAY_SIZE];
        readIps4 = new boolean[ARRAY_SIZE];
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
            String tmp;
            while ((tmp = reader.readLine()) != null) {
                System.out.println(tmp);
                long parsedNumber = Parser.parseToNumber(tmp);
                this.putExistenceToArray(parsedNumber);
            }

            count = this.getCount();
            System.out.printf("Количество уникальных адресов равно: %s%n", count);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    private int getArrayIndex(long parsedNumber) {
        return (int) (parsedNumber % ARRAY_SIZE);
    }

    private long getCount() {
        long count = 0L;
        count = getCount(count, readIps1);
        count = getCount(count, readIps2);
        count = getCount(count, readIps3);
        count = getCount(count, readIps4);
        return count;
    }

    private long getCount(long count, boolean[] array) {
        for (boolean b : array) {
            if (b) count += 1;
        }
        return count;
    }

    private void putExistenceToArray(long parsedNumber) {
        var index = getArrayIndex(parsedNumber);
        System.out.printf("Index of the array: %d%n", index);
        if (parsedNumber < ARRAY_SIZE) {
            readIps1[index] = true;
        } else if (parsedNumber < SECOND_ARRAY_THRESHOLD) {
            readIps2[index] = true;
        } else if (parsedNumber < THIRD_ARRAY_THRESHOLD) {
            readIps3[index] = true;
        } else {
            readIps4[index] = true;
        }
    }
}

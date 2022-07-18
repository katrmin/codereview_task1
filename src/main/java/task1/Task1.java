package task1;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task1 {
    private boolean[] readIps1;
    private boolean[] readIps2;
    private boolean[] readIps3;
    private boolean[] readIps4;

    //Необходимо всего 4 294 967 296 элементов массива
    public Task1() {
        readIps1 = new boolean[1073741824];
        readIps2 = new boolean[1073741824];
        readIps3 = new boolean[1073741824];
        readIps4 = new boolean[1073741824];
    }

    public static void main(String @NotNull [] args) {

        System.out.println(args[0]);
        Task1 task = new Task1();
        task.perform(args[0]);
    }

    public void perform(String arg) {
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(arg))) {
            String tmp;
            int index;

            while ((tmp = reader.readLine()) != null) {
                System.out.println(tmp);
                long parsedNumber = new Parser(tmp).parseToNumber();
                index = getIndex(parsedNumber);
                System.out.printf("Index: %d%n", index);
                this.putExistenceToArray(index, parsedNumber);
            }

            long count = this.getCount(this.readIps1, this.readIps2, this.readIps3, this.readIps4);
            System.out.printf("Количество уникальных адресов равно: %s%n", count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getIndex(long parsedNumber) {
        return (int) (parsedNumber % 1073741824L);
    }

    private long getCount(boolean[] readIps1, boolean[] readIps2, boolean[] readIps3, boolean[] readIps4) {
        long count = 0L;
        for (boolean b : readIps1) {
            if (b) count += 1;
        }
        for (boolean b : readIps2) {
            if (b) count += 1;
        }
        for (boolean b : readIps3) {
            if (b) count += 1;
        }
        for (boolean b : readIps4) {
            if (b) count += 1;
        }
        return count;
    }

    private void putExistenceToArray(int index, long parsedNumber) {
        if (parsedNumber < 1073741824L) {
            readIps1[index] = true;
        } else if (parsedNumber < 2147483648L) {
            readIps2[index] = true;
        } else if (parsedNumber < 3221225472L) {
            readIps3[index] = true;
        } else {
            readIps4[index] = true;
        }
    }
}

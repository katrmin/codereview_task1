package task1;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Task1 {
    public static void main(String @NotNull [] args) {
        System.out.println(args[0]);
        long[] readIps = new long[256 * 256 * 256 * 256];//4 294 967 296
//        readIps[0]=-1;
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(args[0]))) {
            String tmp;
            while ((tmp = reader.readLine()) != null) { //java 2
                System.out.println(tmp);
                Parser parser = new Parser(tmp);
                long parsedNumber = parser.parseToNumber();
                readIps[(int) parsedNumber] = parsedNumber;
            }
            Arrays.stream(readIps).filter(value -> value != 0 || value != -1).count();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package com.yourcodereview.katrmin;

import java.util.Arrays;

public class Storage {
    public static final int ARRAY_SIZE = 1073741824;
    public static final long THIRD_ARRAY_THRESHOLD = ARRAY_SIZE * 3L;
    public static final long SECOND_ARRAY_THRESHOLD = ARRAY_SIZE * 2L;

    private boolean[] readIps1;
    private boolean[] readIps2;
    private boolean[] readIps3;
    private boolean[] readIps4;

    public Storage() {
        readIps1 = new boolean[ARRAY_SIZE];
        readIps2 = new boolean[ARRAY_SIZE];
        readIps3 = new boolean[ARRAY_SIZE];
        readIps4 = new boolean[ARRAY_SIZE];
    }

    public int getArrayIndex(long parsedNumber) {
        return (int) (parsedNumber % ARRAY_SIZE);
    }

    public void putExistenceToArray(long parsedNumber) {
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

    public long getExistingElementsCount() {
        long count = 0L;
        for (boolean[] booleans : Arrays.asList(readIps1, readIps2, readIps3, readIps4)) {
            count = getCount(count, booleans);
        }
        return count;
    }

    private long getCount(long count, boolean[] array) {
        for (boolean b : array) {
            if (b) count += 1;
        }
        return count;
    }
}

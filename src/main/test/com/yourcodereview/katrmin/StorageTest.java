package com.yourcodereview.katrmin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StorageTest {
    private Storage storage = new Storage();

    @Test
    void putExistenceToArray() {
        long parsedNumber = 2071690107L;
        storage.putExistenceToArray(parsedNumber);
        Assertions.assertEquals(1, storage.getExistingElementsCount());
    }

    @Test
    void getExistingElementsCount() {
        for (long i = 0; i < 10; i++)
            storage.putExistenceToArray(i);
        Assertions.assertEquals(10, storage.getExistingElementsCount());
    }
}
package com.yourcodereview.katrmin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class ParserTest {

    @Test
    void parseToNumber() {
        String toTest = "123.123.123.123";
        long expected = 2071690107L;
        long actual = Parser.parseToNumber(toTest);
        assertEquals(expected, actual);
    }

    @Test
    void failParseToNumber() {
        String toTest = "123_123.123";
        assertThrowsExactly(NumberFormatException.class, () -> Parser.parseToNumber(toTest));
    }

    @Test
    void failParseToNumberDueToInvalidFormat() {
        String toTest = "123.123.123.123.123";
        assertThrowsExactly(IllegalArgumentException.class, () -> Parser.parseToNumber(toTest));
    }

    @Test
    void failParseToNumberDueInvalidAddressLength() {
        String toTest = "123.123.123.123.123";
        assertThrowsExactly(IllegalArgumentException.class, () -> Parser.parseToNumber(toTest));
    }
}
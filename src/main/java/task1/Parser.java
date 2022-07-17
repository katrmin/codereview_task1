package task1;

public class Parser {
    private char[] value;

    public Parser(String inputString) {
        value = inputString.toCharArray();
    }

    public long parseToNumber() {
        long parsedNumber = 0L;
        String tmp = "";
        int count = 0;
        for (char ch : value) {
            if (ch != '.') tmp = tmp + ch;
            else {
                switch (count) {
                    case 0 -> parsedNumber = Long.parseLong(tmp) << 24;
                    case 1 -> parsedNumber += Long.parseLong(tmp) << 16;
                    case 2 -> parsedNumber += Long.parseLong(tmp) << 8;
                    default -> throw new IllegalArgumentException("Invalid format string");
                }
                tmp = "";
                count++;
            }
        }
        parsedNumber += Long.parseLong(tmp);
        System.out.printf("Parsed number : %s%n", parsedNumber);
        return parsedNumber;
    }
}

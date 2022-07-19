package task1;

public class Parser {
    public static final int THREE_BYTES = 24;
    public static final int TWO_BYTES = 16;
    public static final int ONE_BYTE = 8;

    public static long parseToNumber(String inputString) {
        char[] charValueOfNumberStringWithDots = inputString.toCharArray();

        long parsedNumber = 0L;
        String numberString = "";
        int count = 0;

        for (char symbol : charValueOfNumberStringWithDots) {
            if (symbol != '.') numberString = numberString + symbol;
            else {
                switch (count) {
                    case 0:
                        parsedNumber = Long.parseLong(numberString) << THREE_BYTES;
                        break;
                    case 1:
                        parsedNumber += Long.parseLong(numberString) << TWO_BYTES;
                        break;
                    case 2:
                        parsedNumber += Long.parseLong(numberString) << ONE_BYTE;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid format string");
                }
                numberString = "";
                count++;
            }
        }
        parsedNumber += Long.parseLong(numberString);
        System.out.printf("Parsed number : %s%n", parsedNumber);
        return parsedNumber;
    }
}

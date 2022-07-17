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
                    case 0:
                        parsedNumber = Long.parseLong(tmp) << 24;
                        break;
                    case 1:
                        parsedNumber = Long.parseLong(tmp) << 16;
                        break;
                    case 2:
                        parsedNumber = Long.parseLong(tmp) << 8;
                        break;
                    case 3:
                        parsedNumber = Long.parseLong(tmp);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid format string");
                }
                tmp = "";
                count++;
            }
        }
        System.out.println(String.format("Parsed number : %s", parsedNumber));
        return parsedNumber;
    }
}

package calculator.model;

public class Number {
    private final int number;

    public Number(String number) {
        validateNumber(number);
        this.number = convertToInteger(number);
    }

    private void validateNumber(String string) {
        if (!string.matches("[1-9]*")) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
        }
    }

    private int convertToInteger(String number) {
        if (number.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(number);
    }

    public int getNumber() {
        return number;
    }
}

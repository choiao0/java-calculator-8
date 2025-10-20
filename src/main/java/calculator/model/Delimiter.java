package calculator.model;

import java.util.regex.Pattern;

public class Delimiter {
    private final String delimiter;

    public Delimiter(String delimiter) {
        validateDelimiter(delimiter);
        this.delimiter = delimiter;
    }

    private void validateDelimiter(String delimiter) {
        if (delimiter.matches("[1-9]")) {
            throw new IllegalArgumentException("양수는 구분자로 사용할 수 없습니다.");
        }
    }

    public String getDelimiter() {
        return Pattern.quote(delimiter);
    }
}

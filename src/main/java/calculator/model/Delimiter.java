package calculator.model;

import java.util.regex.Pattern;

public class Delimiter {
    private final char delimiter;

    public Delimiter(char delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return Pattern.quote(String.valueOf(delimiter));
    }
}

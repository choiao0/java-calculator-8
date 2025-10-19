package calculator.model;

import java.util.regex.Pattern;

public class Delimiter {
    private final String delimiter;

    public Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return Pattern.quote(delimiter);
    }
}

package calculator.model;

import java.util.regex.Pattern;

public class Delimiter {
    private String delimiterRegex;

    public Delimiter() {
        this.delimiterRegex = ",|:";
    }

    public void addDelimiter(String delimiter) {
        delimiterRegex += "|" + Pattern.quote(delimiter);
    }

    public String getDelimiterRegex() {
        return delimiterRegex;
    }
}

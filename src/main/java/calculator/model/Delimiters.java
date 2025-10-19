package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {
    private final List<Delimiter> delimiters;

    public Delimiters(List<Delimiter> delimiters) {
        this.delimiters = new ArrayList<>(delimiters);
    }

    public void addDelimiter(Delimiter delimiter) {
        delimiters.add(delimiter);
    }

    public String getDelimitersRegex() {
        String regex = "";
        for (Delimiter delimiter : delimiters) {
            regex += (delimiter.getDelimiter() + "|");
        }
        return regex.substring(0, regex.length() - 1);
    }
}

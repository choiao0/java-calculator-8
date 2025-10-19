package calculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Delimiters {
    private final List<Delimiter> delimiters;

    public Delimiters(List<Delimiter> delimiters) {
        this.delimiters = new ArrayList<>(delimiters);
    }

    public void addDelimiter(Delimiter delimiter) {
        delimiters.add(delimiter);
    }

    public String getDelimitersRegex() {
        return delimiters.stream()
                .map(Delimiter::getDelimiter)
                .collect(Collectors.joining("|"));
    }
}

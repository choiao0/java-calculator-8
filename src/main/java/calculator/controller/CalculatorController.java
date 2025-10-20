package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;
import calculator.model.Delimiter;
import calculator.model.Delimiters;
import calculator.model.Number;
import calculator.model.Numbers;

import java.util.Arrays;
import java.util.List;

public class CalculatorController {
    private static final String DEFAULT_DELIMITER_COMMA = ",";
    private static final String DEFAULT_DELIMITER_COLON = ":";
    private static final String DELIMITER_SETTING_START = "//";
    private static final String DELIMITER_SETTING_END = "\\n";
    private static final int CUSTOM_DELIMITER_INDEX = 2;
    private static final int CONTENT_START_INDEX = 5;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printInputMessage();
        String inputString = inputView.getInput();

        Delimiters delimiters = new Delimiters(createDefaultDelimiters());
        while (containsCustomDelimiter(inputString)) {
            validateCustomDelimiter(inputString);
            String customDelimiter = String.valueOf(inputString.charAt(CUSTOM_DELIMITER_INDEX));
            delimiters.addDelimiter(new Delimiter(customDelimiter));
            inputString = inputString.substring(CONTENT_START_INDEX);
        }

        String delimitersRegex = delimiters.getDelimitersRegex();
        String[] splitString = splitByDelimiter(inputString, delimitersRegex);
        Numbers numbers = new Numbers(createNumbers(splitString));

        int sum = numbers.calculateSum();
        outputView.printResult(sum);
    }

    private List<Delimiter> createDefaultDelimiters() {
        return List.of(
                new Delimiter(DEFAULT_DELIMITER_COMMA),
                new Delimiter(DEFAULT_DELIMITER_COLON)
        );
    }

    private boolean containsCustomDelimiter(String string) {
        return (string.contains(DELIMITER_SETTING_START) || string.contains(DELIMITER_SETTING_END));
    }

    private void validateCustomDelimiter(String string) {
        String pattern = string.substring(0, 5);
        if (!pattern.startsWith(DELIMITER_SETTING_START) || !pattern.endsWith(DELIMITER_SETTING_END)) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 지정 형식입니다.");
        }
    }

    private String[] splitByDelimiter(String string, String delimiter) {
        return string.split(delimiter, -1);
    }

    private List<Number> createNumbers(String[] splitString) {
        return Arrays.stream(splitString)
                .map(Number::new)
                .toList();
    }
}

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
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printInputMessage();
        String inputString = inputView.getInput();

        Delimiters delimiters = new Delimiters(createDefaultDelimiters());
        if (containsCustomDelimiter(inputString)) {
            validateCustomDelimiter(inputString);
            char customDelimiter = inputString.charAt(2);
            delimiters.addDelimiter(new Delimiter(customDelimiter));
            inputString = inputString.substring(5);
        }

        String delimitersRegex = delimiters.getDelimitersRegex();
        String[] splitString = splitByDelimiter(inputString, delimitersRegex);
        Numbers numbers = new Numbers(createNumbers(splitString));

        int sum = numbers.calculateSum();
        outputView.printResult(sum);
    }

    private List<Delimiter> createDefaultDelimiters() {
        return List.of(new Delimiter(','), new Delimiter(':'));
    }

    private boolean containsCustomDelimiter(String string) {
        return (string.contains("//") && string.contains("\\n"));
    }

    private void validateCustomDelimiter(String string) {
        String pattern = string.substring(0, 5);
        if (!pattern.startsWith("//") || !pattern.endsWith("\\n")) {
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

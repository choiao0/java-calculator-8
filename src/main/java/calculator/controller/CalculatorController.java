package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;
import calculator.model.Delimiter;
import calculator.model.Number;

import java.util.ArrayList;
import java.util.List;

public class CalculatorController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Delimiter delimiter = new Delimiter();
    private final List<Number> numbers = new ArrayList<>();

    public void run() {
        outputView.printInputMessage();
        String inputString = inputView.getInput();

        if (containsCustomDelimiter(inputString)) {
            validateCustomDelimiter(inputString);
            delimiter.addDelimiter(inputString.substring(2, 3));
            inputString = inputString.substring(5);
        }

        String[] splitString = splitByDelimiter(inputString, delimiter.getDelimiterRegex());
        for (String number : splitString) {
            numbers.add(new Number(number));
        }

        int sum = calculateSum(numbers);
        outputView.printResult(sum);
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

    private int calculateSum(List<Number> numbers) {
        int sum = 0;
        for (Number number : numbers) {
            sum += number.getNumber();
        }
        return sum;
    }
}

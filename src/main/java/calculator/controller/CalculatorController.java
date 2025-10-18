package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;
import calculator.model.Delimiter;

public class CalculatorController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Delimiter delimiter = new Delimiter();

    public void run() {
        outputView.printInputMessage();
        String inputString = inputView.getInput();

        if (containsCustomDelimiter(inputString)) {
            validateCustomDelimiter(inputString);
            delimiter.addDelimiter(inputString.substring(2, 3));
            inputString = inputString.substring(5);
        }
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
}

package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printInputMessage();
        String inputString = inputView.getInput();

        if (containsCustomDelimiter(inputString)) {

        }
    }

    private boolean containsCustomDelimiter(String string) {
        if (string.contains("//") && string.contains("\\n")) {
            String pattern = string.substring(0, 5);
            if (!pattern.startsWith("//") || !pattern.endsWith("\\n")) {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 지정 형식입니다.");
            }
            return true;
        }
        return false;
    }
}

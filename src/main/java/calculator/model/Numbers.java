package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public int calculateSum() {
        int sum = 0;
        for (Number number : numbers) {
            sum += number.getNumber();
        }
        return sum;
    }
}

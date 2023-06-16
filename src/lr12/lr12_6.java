import java.util.List;
import java.util.ArrayList;

public class lr12_6 {
    public static List<Integer> getDivisibleNumbers(List<Integer> numbers, int divisor) {
        List<Integer> result = new ArrayList<>();
        for (int number : numbers) {
            if (number % divisor == 0) {
                result.add(number);
            }
        }
        return result;
    }
}

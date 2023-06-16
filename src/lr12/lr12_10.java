import java.util.List;
import java.util.ArrayList;

public class lr12_10 {
    public static List<Integer> getNumbersLessThan(List<Integer> numbers, int value) {
        List<Integer> result = new ArrayList<>();
        for (int number : numbers) {
            if (number < value) {
                result.add(number);
            }
        }
        return result;
    }
}

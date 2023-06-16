import java.util.List;
import java.util.ArrayList;

public class lr12_8 {
    public static List<Integer> getNumbersGreaterThan(List<Integer> numbers, int value) {
        List<Integer> result = new ArrayList<>();
        for (int number : numbers) {
            if (number > value) {
                result.add(number);
            }
        }
        return result;
    }
}

import java.util.List;
import java.util.ArrayList;

public class lr12_4 {
    public static List<Integer> getSquares(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (int number : numbers) {
            result.add(number * number);
        }
        return result;
    }
}

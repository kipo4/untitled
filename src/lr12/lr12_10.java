import java.util.List;
import java.util.ArrayList;

public class lr12_10 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        int maxValue = 4;
        List<Integer> filteredNumbers = filterNumbersByValue(numbers, maxValue);
        System.out.println("Исходный список чисел: " + numbers);
        System.out.println("Список чисел меньше " + maxValue + ": " + filteredNumbers);
    }

    public static List<Integer> filterNumbersByValue(List<Integer> numbers, int maxValue) {
        List<Integer> filteredNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number < maxValue) {
                filteredNumbers.add(number);
            }
        }
        return filteredNumbers;
    }
}

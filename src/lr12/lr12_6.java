import java.util.List;
import java.util.ArrayList;

public class lr12_6 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        int divisor = 2;
        List<Integer> divisibleNumbers = getDivisibleNumbers(numbers, divisor);
        System.out.println("Исходный список чисел: " + numbers);
        System.out.println("Список чисел, делящихся на " + divisor + " без остатка: " + divisibleNumbers);
    }

    public static List<Integer> getDivisibleNumbers(List<Integer> numbers, int divisor) {
        List<Integer> divisibleNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number % divisor == 0) {
                divisibleNumbers.add(number);
            }
        }
        return divisibleNumbers;
    }
}

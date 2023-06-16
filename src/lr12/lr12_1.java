import java.util.Arrays;

public class lr12_1 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] evenNumbers = filterEvenNumbers(numbers);
        System.out.println("Исходный массив: " + Arrays.toString(numbers));
        System.out.println("Массив с четными числами: " + Arrays.toString(evenNumbers));
    }

    public static int[] filterEvenNumbers(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                result[index] = number;
                index++;
            }
        }
        return result;
    }
}

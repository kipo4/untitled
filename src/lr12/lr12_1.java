import java.util.ArrayList;

public class lr12_1 {
    public static int[] getEvenNumbers(int[] numbers) {
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }
        // Преобразование ArrayList в массив
        int[] result = new int[evenNumbers.size()];
        for (int i = 0; i < evenNumbers.size(); i++) {
            result[i] = evenNumbers.get(i);
        }
        return result;
    }
}

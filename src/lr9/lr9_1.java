package lr9;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class lr9_1 {
    public static void main(String[] args) {
        try {
            List<Integer> array = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Введите число (для завершения введите пустую строку): ");
                String input = scanner.nextLine();

                if (input.isEmpty()) {
                    break;
                }

                try {
                    int num = Integer.parseInt(input);
                    array.add(num);
                } catch (NumberFormatException e) {
                    throw new InputMismatchException("Введена строка вместо числа");
                }
            }

            List<Integer> positiveNumbers = new ArrayList<>();
            for (int num : array) {
                if (num > 0) {
                    positiveNumbers.add(num);
                }
            }

            if (positiveNumbers.isEmpty()) {
                throw new IllegalArgumentException("Отсутствуют положительные числа в массиве");
            }

            double average = calculateAverage(positiveNumbers);
            System.out.println("Среднее значение положительных чисел: " + average);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }

    private static double calculateAverage(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.size();
    }
}
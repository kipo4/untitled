package lr9;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class lr9_3 {
    public static void main(String[] args) {
        try {
            List<Byte> array = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Введите число (для завершения введите пустую строку): ");
                String input = scanner.nextLine();

                if (input.isEmpty()) {
                    break;
                }

                try {
                    byte num = Byte.parseByte(input);
                    array.add(num);
                } catch (NumberFormatException e) {
                    throw new InputMismatchException("Введена строка вместо числа");
                }
            }

            int total = 0;
            for (byte num : array) {
                if (num < 0 || num > 255) {
                    throw new IllegalArgumentException("Значение вне диапазона byte");
                }
                total += num;
            }

            System.out.println("Сумма элементов массива: " + total);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }
}
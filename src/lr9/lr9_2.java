package lr9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class lr9_2 {
    public static void main(String[] args) {
        try {
            int[][] matrix = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };

            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите номер столбца: ");
            int columnNum = scanner.nextInt();

            if (columnNum < 0 || columnNum >= matrix[0].length) {
                throw new ArrayIndexOutOfBoundsException("Некорректный номер столбца");
            }

            int[] column = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                column[i] = matrix[i][columnNum];
            }

            System.out.println("Столбец с номером " + columnNum + ":");
            for (int num : column) {
                System.out.println(num);
            }

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введена строка вместо числа");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }
}
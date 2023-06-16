import java.util.Scanner;

public class lr11_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int decimalNumber = scanner.nextInt();

        String binaryNumber = convertDecimalToBinary(decimalNumber);
        System.out.println("Двоичное представление числа: " + binaryNumber);
    }

    private static String convertDecimalToBinary(int decimalNumber) {
        if (decimalNumber == 0) {
            return "0";
        } else if (decimalNumber == 1) {
            return "1";
        } else {
            int remainder = decimalNumber % 2;
            int quotient = decimalNumber / 2;
            String recursiveBinary = convertDecimalToBinary(quotient);
            return recursiveBinary + remainder;
        }
    }
}

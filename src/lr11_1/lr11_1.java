public class lr11_1 {
    public static void main(String[] args) {
        // Пример 1
        System.out.println("Пример 1:");
        printNumberSequence(0);

        // Пример 2
        System.out.println("\nПример 2:");
        printReverseNumberSequence(0);

        // Пример 3
        System.out.println("\nПример 3:");
        printSequenceWithRecursion(0);

        // Пример 4
        System.out.println("\nПример 4:");
        int factorialResult = factorial(5);
        System.out.println("Факториал числа 5: " + factorialResult);

        // Пример 5
        System.out.println("\nПример 5:");
        int fibonacciResult = fibonacci(8);
        System.out.println("Число Фибоначчи с индексом 8: " + fibonacciResult);
    }

    // Пример 1: вывод последовательности чисел
    public static void printNumberSequence(int x) {
        if (x >= 0 && x < 20) {
            System.out.println(x);
            printNumberSequence(2 * x + 1);
        }
    }

    // Пример 2: вывод последовательности чисел в обратном порядке
    public static void printReverseNumberSequence(int x) {
        if (x >= 0 && x < 20) {
            printReverseNumberSequence(2 * x + 1);
            System.out.println(x);
        }
    }

    // Пример 3: вывод значения параметра перед и после рекурсивного вызова
    public static void printSequenceWithRecursion(int x) {
        System.out.println("До вызова: " + x);
        if (x >= 0 && x < 20) {
            printSequenceWithRecursion(2 * x + 1);
        }
        System.out.println("После вызова: " + x);
    }

    // Пример 4: вычисление факториала числа с использованием рекурсии
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // Пример 5: вывод числа Фибоначчи по его индексу в последовательности
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
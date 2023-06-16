import java.util.Scanner;

public class lr11_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Введите элементы массива:");
        inputArray(array, 0);

        System.out.println("Введенный массив:");
        outputArray(array, 0);
    }

    public static void inputArray(int[] array, int index) {
        if (index < array.length) {
            Scanner scanner = new Scanner(System.in);
            array[index] = scanner.nextInt();
            inputArray(array, index + 1);
        }
    }

    public static void outputArray(int[] array, int index) {
        if (index < array.length) {
            System.out.println(array[index]);
            outputArray(array, index + 1);
        }
    }
}
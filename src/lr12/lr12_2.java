import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class lr12_2 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 5, 6, 7, 8};
        int[] intersection = intersectArrays(array1, array2);
        System.out.println("Первый массив: " + Arrays.toString(array1));
        System.out.println("Второй массив: " + Arrays.toString(array2));
        System.out.println("Пересечение массивов: " + Arrays.toString(intersection));
    }

    public static int[] intersectArrays(int[] array1, int[] array2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int num : array1) {
            set1.add(num);
        }

        for (int num : array2) {
            set2.add(num);
        }

        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        int index = 0;
        for (int num : set1) {
            result[index] = num;
            index++;
        }
        return result;
    }
}
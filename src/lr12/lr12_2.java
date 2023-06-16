import java.util.HashSet;

public class lr12_2 {
    public static int[] getCommonElements(int[] array1, int[] array2) {
    HashSet<Integer> set1 = new HashSet<>();
    HashSet<Integer> set2 = new HashSet<>();
    for (int num : array1) {
        set1.add(num);
    }
    for (int num : array2) {
        if (set1.contains(num)) {
            set2.add(num);
        }
    }
    int[] result = new int[set2.size()];
    int i = 0;
    for (int num : set2) {
        result[i++] = num;
    }
    return result;
}
}

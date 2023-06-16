import java.util.List;
import java.util.ArrayList;

public class lr12_7 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("world");
        strings.add("Java");
        strings.add("Program");
        int minLength = 5;
        List<String> filteredStrings = filterStringsByLength(strings, minLength);
        System.out.println("Исходный список строк: " + strings);
        System.out.println("Список строк длинее " + minLength + " символов: " + filteredStrings);
    }

    public static List<String> filterStringsByLength(List<String> strings, int minLength) {
        List<String> filteredStrings = new ArrayList<>();
        for (String str : strings) {
            if (str.length() > minLength) {
                filteredStrings.add(str);
            }
        }
        return filteredStrings;
    }
}

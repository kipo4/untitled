import java.util.ArrayList;
import java.util.List;

public class lr12_3 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("world");
        strings.add("Java");
        strings.add("Program");
        List<String> filteredStrings = filterStringsStartingWithUppercase(strings);
        System.out.println("Исходный список: " + strings);
        System.out.println("Список строк, начинающихся с большой буквы: " + filteredStrings);
    }

    public static List<String> filterStringsStartingWithUppercase(List<String> strings) {
        List<String> result = new ArrayList<>();
        for (String str : strings) {
            if (!str.isEmpty() && Character.isUpperCase(str.charAt(0))) {
                result.add(str);
            }
        }
        return result;
    }
}
import java.util.List;
import java.util.ArrayList;

public class lr12_9 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Hello123");
        strings.add("world!");
        strings.add("Java2021");
        strings.add("Program");
        List<String> filteredStrings = filterStringsByLetters(strings);
        System.out.println("Исходный список строк: " + strings);
        System.out.println("Список строк, содержащих только буквы: " + filteredStrings);
    }

    public static List<String> filterStringsByLetters(List<String> strings) {
        List<String> filteredStrings = new ArrayList<>();
        for (String str : strings) {
            if (str.matches("[a-zA-Z]+")) {
                filteredStrings.add(str);
            }
        }
        return filteredStrings;
    }
}


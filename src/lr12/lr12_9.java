import java.util.List;
import java.util.ArrayList;

public class lr12_9 {
    public static List<String> getStringsWithOnlyLetters(List<String> strings) {
        List<String> result = new ArrayList<>();
        for (String str : strings) {
            if (str.matches("[a-zA-Z]+")) {
                result.add(str);
            }
        }
        return result;
    }
}

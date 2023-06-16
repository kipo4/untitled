import java.util.List;
import java.util.ArrayList;

public class lr12_5 {
    public static List<String> getStringsContainingSubstring(List<String> strings, String substring) {
        List<String> result = new ArrayList<>();
        for (String str : strings) {
            if (str.contains(substring)) {
                result.add(str);
            }
        }
        return result;
    }
}

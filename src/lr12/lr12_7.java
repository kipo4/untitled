import java.util.List;
import java.util.ArrayList;

public class lr12_7 {
    public static List<String> getStringsLongerThan(List<String> strings, int length) {
        List<String> result = new ArrayList<>();
        for (String str : strings) {
            if (str.length() > length) {
                result.add(str);
            }
        }
        return result;
    }
}

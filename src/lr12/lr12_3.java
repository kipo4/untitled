import java.util.List;
import java.util.ArrayList;

public class lr12_3 {
    public static List<String> getStringsStartingWithCapital(List<String> strings) {
        List<String> result = new ArrayList<>();
        for (String str : strings) {
            if (Character.isUpperCase(str.charAt(0))) {
                result.add(str);
            }
        }
        return result;
    }
}

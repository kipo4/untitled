import java.util.HashMap;

public class lr11_6 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();

        // Заполнение HashMap 10 объектами <Integer, String>
        hashMap.put(1, "строка1");
        hashMap.put(2, "строка2");
        hashMap.put(3, "строка3");
        hashMap.put(4, "строка4");
        hashMap.put(5, "строка5");
        hashMap.put(6, "строка6");
        hashMap.put(7, "строка7");
        hashMap.put(8, "строка8");
        hashMap.put(9, "строка9");
        hashMap.put(10, "строка10");

        // Нахождение строк, у которых ключ > 5
        for (Integer key : hashMap.keySet()) {
            if (key > 5) {
                System.out.println(hashMap.get(key));
            }
        }

        // Вывод строк через запятую, если ключ = 0
        if (hashMap.containsKey(0)) {
            StringBuilder result = new StringBuilder();
            for (Integer key : hashMap.keySet()) {
                if (key == 0) {
                    result.append(hashMap.get(key)).append(",");
                }
            }
            System.out.println(result.deleteCharAt(result.length() - 1).toString());
        }

        // Перемножение всех ключей, где длина строки > 5
        int product = 1;
        for (Integer key : hashMap.keySet()) {
            String value = hashMap.get(key);
            if (value.length() > 5) {
                product *= key;
            }
        }
        System.out.println("Произведение ключей, где длина строки больше 5: " + product);
    }
}

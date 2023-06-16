import java.util.ArrayList;

public class ArrayListSimulation {
    public static int getLastPerson(int n) {
        ArrayList<Integer> circle = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        int currentIndex = 0;
        while (circle.size() > 1) {
            currentIndex = (currentIndex + 1) % circle.size();
            circle.remove(currentIndex);
        }

        return circle.get(0);
    }

    public static void main(String[] args) {
        int n = 10; // Пример числа людей
        int lastPerson = getLastPerson(n);
        System.out.println("Последний оставшийся человек: " + lastPerson);
    }
}
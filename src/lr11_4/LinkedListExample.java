// Создаем класс для представления узла списка
class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class LinkedListExample {
    public static void main(String[] args) {
        // Создаем список из пяти элементов
        Node head = createLinkedList(5);

        // Выводим значения полей на экран
        printLinkedList(head);
    }

    // Метод для создания однонаправленного списка с заданным количеством элементов
    public static Node createLinkedList(int size) {
        Node head = new Node(1);
        Node curr = head;

        for (int i = 2; i <= size; i++) {
            Node newNode = new Node(i);
            curr.next = newNode;
            curr = newNode;
        }

        return head;
    }

    // Метод для вывода значений полей на экран
    public static void printLinkedList(Node head) {
        Node curr = head;

        while (curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }
}

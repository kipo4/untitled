public class LinkedList_B {
    private Node head;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void createHeadRec(int data) {
        head = createHeadRecHelper(head, data);
    }

    private Node createHeadRecHelper(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }
        current.next = createHeadRecHelper(current.next, data);
        return current;
    }

    public void createTailRec(int data) {
        head = createTailRecHelper(head, data);
    }

    private Node createTailRecHelper(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }
        current.next = createTailRecHelper(current.next, data);
        return current;
    }

    public String toStringRec() {
        if (head == null) {
            return "Empty list";
        }
        return toStringRecHelper(head);
    }

    private String toStringRecHelper(Node current) {
        if (current.next == null) {
            return String.valueOf(current.data);
        }
        return current.data + " " + toStringRecHelper(current.next);
    }
}
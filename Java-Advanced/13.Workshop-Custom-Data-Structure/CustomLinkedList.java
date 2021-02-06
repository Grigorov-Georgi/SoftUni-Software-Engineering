import java.util.function.Consumer;

public class CustomLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        private int element;
        private Node next;
        private Node prev;

        public Node(int element) {
            this.element = element;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addFirst(int element) {
        Node newNode = new Node(element);
        if (this.head != null) {
            newNode.next = this.head;
        }

        if (this.head != null) {
            newNode.next = this.head;
            this.head.prev = newNode;
        }

        this.head = newNode;

        if (isEmpty()) {
            this.tail = this.head;
        }

        this.size++;
    }

    public int get(int index) {
        validateIndex(index);

        Node current = this.head;
        int currentIndex = 0;
        int element = 0;

        while (current != null) {
            if (index == currentIndex) {
                element = current.element;
                break;
            }
            currentIndex++;
            current = current.next;
        }
        return element;
    }

    public int removeFirst() {
        if (this.isEmpty()) {
            throw new IllegalStateException("The data structure you're trying to remove from is empty!");
        }
        int removedElement = this.head.element;
        this.head = this.head.next;

        if (this.size > 1) {
            this.head.prev = null;
        }

        this.size--;

        return removedElement;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node current = this.head;

        while (current != null) {
            consumer.accept(current.element);
            current = current.next;
        }
    }

    public int[] toArray() {
        int[] array = new int[this.size];

        Node current = this.head;
        int index = 0;

        while (current != null) {
            array[index] = current.element;
            index++;
            current = current.next;
        }

        return array;
    }

    public void addLast(int element) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }
        Node newNode = new Node(element);
        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
        this.size++;
    }

    public int removeLast() {

        if (this.size < 2) {
            return removeFirst();
        }
        int removedElement = this.tail.element;
        this.tail = this.tail.prev;
        this.tail.next = null;
        this.size--;

        return removedElement;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException(String.format("Index: %d, size %d - There is no such index in data structure.", index, this.size));
        }
    }

}

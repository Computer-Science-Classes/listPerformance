import java.util.NoSuchElementException;

public class LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail = tail.next = newNode;
        }
    }

    public void addAtIndex(int index, E data) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }

        Node<E> newNode = new Node<>(data);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
            return;
        }

        Node<E> current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Index exceeds the list size");
            }
            current = current.next;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Index exceeds the list size");
        }

        newNode.next = current.next;
        current.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }
    }

    public void remove(E data) {
        if (head == null) {
            System.out.println("List is empty");
        }

        // removal of head node
        if (head.data.equals(data)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }

        Node<E> curr = head;
        while (curr.next != null) {
            if (curr.next.data.equals(data)) {
                curr.next = curr.next.next;
                if (curr.next == null) {
                    tail = curr;
                }
                return;
            }
            curr = curr.next;
        }
        throw new NoSuchElementException("Element " + data.toString() + " not found in the list");
    }

}

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
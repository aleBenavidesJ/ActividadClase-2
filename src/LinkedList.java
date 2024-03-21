import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public void insertList(LinkedList<T> list) {
        for (T data : list) {
            insert(data);
        }
    }

    public LinkedList<T> subList(int start, int size) {
        LinkedList<T> newList = new LinkedList<>();
        Node<T> current = first;
        int count = 0;

        while (current != null && count < start + size) {
            if (count >= start) {
                newList.insert(current.data);
            }
            current = current.next;
            count++;
        }

        return newList;
    }

    public void reverse() {
        Node<T> prev = null;
        Node<T> current = first;
        Node<T> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        first = prev;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = first;
            private Node<T> prev;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                prev = current;
                T data = current.data;
                current = current.next;
                return data;
            }

            //este metodo lo tuve que añadir para poder hacer la tercer prueba unitaria
            @Override
            public void remove() {
                if (prev == null) {
                    throw new IllegalStateException("No element to remove");
                }
                if (prev == first) {
                    first = first.next;
                } else {
                    Node<T> temp = first;
                    while (temp.next != prev) {
                        temp = temp.next;
                    }
                    temp.next = prev.next;
                }
                size--;
                prev = null;
            }
        };
    }
}
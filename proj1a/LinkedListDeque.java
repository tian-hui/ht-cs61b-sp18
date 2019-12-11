public class LinkedListDeque<T> {
    public class Node {
        public T item;
        public Node prev;
        public Node next;

        public Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;
    private int size;
    private Node last;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        last = sentinel;
        sentinel.prev = last;
        last.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next = newNode;

        if (size == 0) {
            last = newNode;
            sentinel.prev = last;
        }
        size += 1;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, last, last.next);
        last.next = newNode;
        last = newNode;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
    }

    public T removeFirst() {
        if (sentinel.next != sentinel) {
            T firstItem = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return firstItem;
        } else {
            return null;
        }
    }

    public T removeLast() {
        if (last != sentinel) {
            T lastItem = last.item;
            last.prev.next = sentinel;
            last = last.prev;
            size -= 1;
            return lastItem;
        } else {
            return null;
        }
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            int i = 0;
            Node ptr = sentinel.next;
            while (i < index) {
                ptr = ptr.next;
                i += 1;
            }
            return ptr.item;
        } else {
            return null;
        }
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index == 0) {
            return sentinel.next.item;
        }
        this.removeFirst();
        return this.getRecursive(index - 1);
    }
}
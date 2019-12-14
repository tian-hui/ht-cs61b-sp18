public class LinkedListDeque<T> {
    private class Node {
        private T item;
        private Node prev;
        private Node next;

        public Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private int size;
    private Node sentinel;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node ptr = sentinel;
        while (ptr.next != sentinel) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T firstItem = sentinel.next.item;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return firstItem;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T lastItem = sentinel.prev.item;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size -= 1;
            return lastItem;
        }
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return sentinel.next.item;
        } else {
            LinkedListDeque<T> newList = copyList();
            newList.removeFirst();
            return newList.getRecursive(index - 1);
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            int i;
            Node ptr = sentinel;
            for (i = 0; i <= index; i += 1) {
                ptr = ptr.next;
            }
            return ptr.item;
        }
    }

    public LinkedListDeque<T> copyList() {
        LinkedListDeque<T> newList = new LinkedListDeque<T>();
        Node ptr = sentinel.next;
        while (ptr != sentinel) {
            newList.addLast(ptr.item);
            ptr = ptr.next;
        }
        return newList;
    }
}


public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private int front;
    private static int refactor = 2;
    private static double usageFactor = 0.25;

    private int minusOne(int index) {
        if (index - 1 < 0) {
            return items.length - index - 1;
        }
        return calcIndex(index - 1);
    }

    private int calcIndex(int index) {
        return index % items.length;
    }


    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        front = 0;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * refactor);
        }
        front = minusOne(front);
        items[front] = item;
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * refactor);
        }
        items[calcIndex(front + size)] = item;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int i;
        for (i = 0; i < size; i++) {
            System.out.print(items[calcIndex(i + front)] + " ");
        }
    }

    public T removeFirst() {
        if ((double)size / items.length < usageFactor
                && size > 16) {
            resize(items.length / 2);
        }
        if (size == 0) {
            return null;
        }
        T firstItem = items[front];
        front = calcIndex(front + 1);
        size -= 1;
        return firstItem;
    }

    public T removeLast() {
        if ((double)size / items.length < usageFactor
                && size > 16) {
            resize(items.length / 2);
        }
        if (size == 0) {
            return null;
        }
        T lastItem = items[calcIndex(front + size - 1)];
        size -= 1;
        return lastItem;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            return items[calcIndex(front + index)];
        }
    }

    private void resize(int newLength) {
        T[] newItems = (T[]) new Object[newLength];

        int i;
        for (i = 0; i < size; i += 1) {
            newItems[i] = items[calcIndex(front + i)];
        }
        items = newItems;
        front = 0;
    }
}


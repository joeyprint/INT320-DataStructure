package sit.int320.ec.list;

import java.util.AbstractList;

public class SimpleArrayList<E> extends AbstractList<E> {

    private static final int INIT_SIZE = 10;
    private int size;
    private E[] elements;

    public SimpleArrayList(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    public SimpleArrayList() {
        this(INIT_SIZE);
    }

    @Override
    public E get(int index) {
        checkPosition(index);
        return elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    private void checkPosition(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
        //elements[size] = e;
        //size = size+1;
        return true;
    }

    @Override
    public void add(int index, E e) {
        ensureCapacity(size + 1);
        checkPosition(index == size ? index - 1 : index);
        //your code --> System.arraycopy();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = e;
        size++;

    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elements.length;
        if (minCapacity > oldCapacity) {
            E oldElement[] = elements;
            int newCapacity = (oldCapacity * 3) / 2 + 1;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = (E[]) new Object[newCapacity];
            System.arraycopy(oldElement, 0, elements, 0, size);
        }
    }

}

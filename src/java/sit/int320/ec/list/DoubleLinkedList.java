package sit.int320.ec.list;

import java.util.AbstractSequentialList;
import java.util.ListIterator;

public class DoubleLinkedList<E> extends AbstractSequentialList<E> {

    Node<E> first;
    Node<E> last;
    int size;
    
    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    private void checkPosition(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E get(int index) {
        checkPosition(index);
        int count = 0;
        Node<E> currentNode = first;
        while (true){
            if(index == count){
                return currentNode.item;
            }
            else {
                currentNode = currentNode.next;
                count++;
            }
        }
    }

    private static class Node<E> {

        E item;
        Node<E> next;
        Node<E> prov;

        public Node(Node<E> prov, E item, Node<E> next) {
            this.prov = prov;
            this.item = item;
            this.next = next;
        }

    }
}

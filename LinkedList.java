import java.io.Serializable;

public class LinkedList<T> implements Serializable {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // append a value to the end of the list
    public boolean addLast(T o) {
        Node node = new Node(o);
        if (isEmpty()){
            head = tail = node;
            size++;
            return true;
        }

        node.setPrevious(tail);
        tail.setNext(node);
        tail = node;
        size++;
        return true;
    }

    // remove the last element from the list
    public boolean removeLast() {
        if (isEmpty()) return false;
        if (size == 1) {
            head = tail = null;
            size--;
            return true;
        }
        tail.getPrevious().setNext(null);
        tail = tail.getPrevious();
        size--;
        return true;

    }

    // remove the first element from the list
    public boolean removeFirst() {
        if (isEmpty()) return false;
        if (size == 1) {
            head = tail = null;
            size--;
            return true;
        }
        head.getNext().setPrevious(null);
        head = head.getNext();
        size--;
        return true;
    }

    // remove an item at a given index
    public boolean removeAt(int i) {
        if (i < 0 || i >= size) return false;
        Node target = getNode(i);
        if(target == head) return removeFirst();
        if (target == tail) return removeLast();

        Node nextNode = target.getNext();
        Node prevNode = target.getPrevious();

        prevNode.setNext(nextNode);
        nextNode.setPrevious(prevNode);
        size--;
        return true;
    }

    // find a node by index
    private Node getNode(int n) {
        if (n < 0 || n >= size) return null;
        Node current = head;
        for (int i = 1; i <= n; i++) {
            current = current.getNext();
        }
        return current;
    }

    public T get(int i) {
        Node node = getNode(i);
        return node != null ? (T)node.getData(): null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {return size;}
}

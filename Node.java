public class Node<T> {
    private T data;
    private Node next;
    private Node previous;


    public Node(T data) {
        this.data = data;
        next = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public T getData() {return data;}
    public Node getNext() {return next;}
    public Node getPrevious() {return previous;}
    public boolean hasNext() {return getNext() != null;}
    public boolean hasPrevious() {return getPrevious() != null;}
}

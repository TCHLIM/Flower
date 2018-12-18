package ADT;

public class Node_1<T> {

    private T data;
    private Node_1 next;

    public Node_1(T data) {
        this.data = data;
        next = null;
    }

    public Node_1(T data, Node_1 next) {
        this.data = data;
        this.next = next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node_1 next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public Node_1 getNext() {
        return next;
    }

}
public class Node<T>{
    Node<T> next = null;
    Node<T> previous = null;
    T value;

    public Node() {
    }
    public Node(T value){
        this.next = null;
        this.previous = null;
        this.value = value;
    }
    public Node<T> getNext() {
        return next;
    }
    public Node<T> getPrevious() {
        return previous;
    }
    public T getValue() {
        return value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
    public void setValue(T value) {
        this.value = value;
    }
}

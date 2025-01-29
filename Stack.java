public class Stack<T> implements IStack{
    Node<T> first = new Node<>();
    Node<T> last = first;

    @Override
    public void push(int value) {
        last.setNext(new Node<T>(value));
        Node<T> aux = last;
        last = last.getNext();
        last.setPrevious(aux);
    }

    @Override
    public int pop() {
        int val = last.getValue();
        last = last.getPrevious();
        last.setNext(null); 
        return val;
    }
    @Override
    public int operation(char operator, int value1, int value2) {
        int result = 0;
        switch (operator) {
            case '+':
                result = value1 + value2;
                break;
            case '-':
                result = value1 - value2;
                break;
            case '/':
                result = value1 / value2;
                break;
            case '%':
                result = value1 % value2;
                break;
            default:
                throw new IllegalArgumentException("Incorrect Operator");
        }
        return result;
    }

    public Node<T> getFirst() {
        return first;
    }
    public Node<T> getLast() {
        return last;
    }
    public void setFirst(Node<T> first) {
        this.first = first;
    }
    public void setLast(Node<T> last) {
        this.last = last;
    }
}

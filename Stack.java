public class Stack<T> implements IStack<T>{
    Node<T> first = new Node<>();
    Node<T> last = first;

    @Override
    public void push(T value) {
        last.setNext(new Node<T>(value));
        Node<T> aux = last;
        last = last.getNext();
        last.setPrevious(aux);
    }

    @Override
    public T pop() {
        T val = last.getValue();
        last = last.getPrevious();
        last.setNext(null); 
        return val;
    }
    @Override
    public T operation(char operator, T value1, T value2) {
        int result = 0;
        int val1 = ((Integer) value1).intValue();
        int val2 = ((Integer) value2).intValue();
        switch (operator) {
            case '+':
                result = val1 + val2;
                break;
            case '-':
                result = val1 - val2;
                break;
            case '*':
                result = val1 * val2;
                break;
            case '/':
                result = val1 / val2;
                break;
            case '%':
                result = val1 % val2;
                break;
            default:
                throw new IllegalArgumentException("Incorrect Operator");
        }
        return (T) Integer.valueOf(result);
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

/*  Tarea: Hoja de trabajo 2
    Curso: Algoritmos y estructuras de datos
    Grupo: 6
    Alumnos: Avilés, Alejandra (24722); Girón, Jackelyn (24737); Tan, Sergio (24759)
    Fecha de última modificación: 2025-01-30
    Descripción de Stack.java: Trabajo en la logística de los métodos a emplear en la stack.
 */
public class Stack<T> implements IStack<T>{
    Node<T> first = new Node<>();
    Node<T> last = first;

    @Override
    public void push(T value) {
        last.setNext(new Node<>(value));
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
    @SuppressWarnings({"unchecked", "UnnecessaryBoxing"})
    @Override
    public T operation(char operator, T value1, T value2) {
        int result = 0;
        int val1 = ((Integer) value1);
        int val2 = ((Integer) value2);
        switch (operator) {
            case '+' -> result = val1 + val2;
            case '-' -> result = val1 - val2;
            case '*' -> result = val1 * val2;
            case '/' -> result = val1 / val2;
            case '%' -> result = val1 % val2;
            default -> throw new IllegalArgumentException("Incorrect Operator");
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

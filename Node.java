/*  Tarea: Hoja de trabajo 2
    Curso: Algoritmos y estructuras de datos
    Grupo: 6
    Alumnos: Avilés, Alejandra (24722); Girón, Jackelyn (24737); Tan, Sergio (24759)
    Fecha de última modificación: 2025-01-30
    Descripción de Node.java: Trabajo en la logística de los métodos a emplear para obtener los valores u operadores de la stack.
 */
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

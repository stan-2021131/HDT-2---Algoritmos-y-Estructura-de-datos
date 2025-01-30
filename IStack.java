/*  Tarea: Hoja de trabajo 2
    Curso: Algoritmos y estructuras de datos
    Grupo: 6
    Alumnos: Avilés, Alejandra (24722); Girón, Jackelyn (24737); Tan, Sergio (24759)
    Fecha de última modificación: 2025-01-30
    Descripción de IStack.java: Métodos considerados necesarios para llevar a cabo la tarea.
 */
public interface IStack<T>{
    void push(T value);
    T pop();
    T operation(char operator, T value1, T value2);
}
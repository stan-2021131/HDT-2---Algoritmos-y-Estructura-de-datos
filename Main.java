/*  Tarea: Hoja de trabajo 2
    Curso: Algoritmos y estructuras de datos
    Grupo: 6
    Alumnos: Avilés, Alejandra (24722); Girón, Jackelyn (24737); Tan, Sergio (24759)
    Fecha de última modificación: 2025-01-30
    Descripción de Main.java: Interfaz que interactúa con el usuario y maneja los métodos de ADTCalculator.java y el archivo que posee las operaciones postfix.
 */
public class Main {
        public static void main(String[] args) {
            ADTCalculator myCalculator = new ADTCalculator();
            myCalculator.calculate("datos.txt");
        }
        
}
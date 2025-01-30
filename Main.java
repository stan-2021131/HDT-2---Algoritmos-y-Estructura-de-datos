import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static char[] operators = {'+', '-', '*', '/', '%'};
        @SuppressWarnings("unchecked")
        public static void main(String[] args) {
            @SuppressWarnings("rawtypes")
            Stack myStack = new Stack<Integer>();
            //Nombre del archivo donde estarán las operaciones. Cambiarlo si se quiere usar otro archivo
            String filename = "datos.txt";
    
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))){
                String line;
                while ((line = bufferedReader.readLine()) != null){
                    clear(myStack);
                    String[] data = line.split(" ");
                    for(String value: data){
                        //Revisa si el valor es positivo
                        if(value.matches("\\d+")){
                            myStack.push(Integer.valueOf(value));
                        }else if(value.length() == 1 && isOperator(value.charAt(0))){
                            //Verifica si hay suficientes operandos en la pila
                            if(size(myStack) < 2){
                                System.out.println("There are not enough operands");
                                clear(myStack);
                                return;
                            }
                            //Obtiene los últimos 2 valores agregados a la pila y el operador a usar
                            int b = ((Integer) myStack.pop());
                            int a = ((Integer) myStack.pop());
                            char operator = value.charAt(0);
                            int result = (Integer) myStack.operation(operator, a, b);
                            myStack.push(result);
                        }else{
                            //Si el dato no puede ser operado limpia la pila y no regresa un resultado
                            System.out.println("Invalid value" + value);
                            clear(myStack);
                            return;
                        }
                    }
                    if (size(myStack) == 1) {
                        System.out.println("The result of the line is: " + myStack.pop());
                    } else {
                        System.out.println("Error: There is no single final result on the stack for this line.");
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            } 
    
            /* //Ejemplo base del funcionamiento de la pila 
            myStack.push(3);
            myStack.push(2);
            myStack.push(5);
            System.out.println(myStack.size());
            int b = ((Integer) myStack.pop()).intValue();
            int a = ((Integer) myStack.pop()).intValue();
            //El operador se pasa como un texto, entre ''
            System.out.println(a);
            System.out.println(b);
            System.out.println(myStack.size());
            System.out.println("El resultado de la operación es: " + myStack.operation('+', a, b));
            //Condicional que compara el último y primer elemento de la lista
            if(myStack.getLast() == myStack.getFirst() ){
                System.out.println("Son el mismo objeto. Final del stack");
            }else{
                System.out.println("No, pos entonces no son lo mismo. Quedan objetos en el stack :p");
            } */
        }
        public static boolean isOperator(char operator){
        for(char validOpeator : operators)
            if(operator == validOpeator) return true;
        return false;
        }

        public static <T> int size(@SuppressWarnings("rawtypes") Stack stack){
            int count = 0;
            @SuppressWarnings("unchecked")
            Node<T> current = stack.first.getNext();
            while(current != null){
                count++;
                current = current.getNext();
            }
            return count;
        }

        public static void clear(@SuppressWarnings("rawtypes") Stack stack){
            while (size(stack) > 0) {
                stack.pop();
            }
        }
}

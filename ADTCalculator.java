import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ADTCalculator {
    char[] operators = {'+', '-', '*', '/', '%'};

    @SuppressWarnings("unchecked")
    public void calculate (String file){
        @SuppressWarnings("rawtypes")
        Stack myStack = new Stack<Integer>();

        //Nombre del archivo donde estarán las operaciones. Cambiarlo si se quiere usar otro archivo
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                clear(myStack);
                String[] data = line.split(" ");
                boolean error = false;

                for(String value : data){
                    //Revisa si el valor es positivo
                    if(value.matches("\\d+")){
                        myStack.push(Integer.valueOf(value));
                    }else if(value.length() == 1 && isOperator(value.charAt(0))){ //Es operador
                        //Verifica si hay suficientes operandos en la pila
                        if(size(myStack) < 2){
                            System.out.println("Error: There are not enough operands in line: " + line);
                            error = true;
                            clear(myStack);
                            break;
                            //return;
                        }
                        //Obtiene los últimos 2 valores agregados a la pila y el operador a usar
                        int b = ((Integer) myStack.pop());
                        int a = ((Integer) myStack.pop());
                        char operator = value.charAt(0);

                        // Manejo de división por 0
                        if ((operator == '/') && (a == 0 || b == 0 || a == 0 && b == 0)){
                            System.out.println("Error: Division by zero in line: " + line);
                            error = true;
                            clear(myStack);
                            break;
                            }

                        // Manejo de modulo por 0
                        if ((operator == '%') && (a == 0 || b == 0 || a == 0 && b == 0)){
                            System.out.println("Error: Modulo by zero in line: " + line);
                            error = true;
                            clear(myStack);
                            break;
                        }

                        int result = (Integer) myStack.operation(operator, a, b);
                        myStack.push(result);
                    }else{
                        //Si el dato no puede ser operado limpia la pila y no regresa un resultado
                        System.out.println("Error: Invalid value '" + value + "' in line: " + line);
                        error = true;
                        clear(myStack);
                        break;
                    }
                }
                if (!error){    //La operación puede ser efectuada sin problemas
                    if (size(myStack) == 1) {
                        System.out.println("The result of the line (" + line + ") is: " + myStack.pop());
                    } else { // Hay más de un elemento en la stack y no hay más operadores
                        System.out.println("Error: There is no single final result on the stack for the line: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } 
    }

    // Validando los operadores ingresados
    public boolean isOperator(char operator){
        for(char validOpeator : operators)
            if(operator == validOpeator) return true;
        return false;
        }

    public  <T> int size(@SuppressWarnings("rawtypes") Stack stack){
            int count = 0;
            @SuppressWarnings("unchecked")
            Node<T> current = stack.first.getNext();
            while(current != null){
                count++;
                current = current.getNext();
            }
            return count;
        }

    public void clear(@SuppressWarnings("rawtypes") Stack stack){
            while (size(stack) > 0) {
                stack.pop();
            }
    }
}
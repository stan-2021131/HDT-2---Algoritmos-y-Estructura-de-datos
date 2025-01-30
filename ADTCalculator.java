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
    }

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

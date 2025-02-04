
import org.junit.jupiter.api.*;
public class StackTest {
    Stack<Integer> stack = new Stack<>();

    @BeforeEach
    void setUp(){
        stack = new Stack<>();
    }
    @Test
    void testPushHappyPath(){
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assertions.assertEquals(3, stack.getLast().getValue());
        Assertions.assertEquals(1, stack.getFirst().getNext().getValue());
    }

    @Test
    void testPopHappyPath(){
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assertions.assertEquals(3, stack.pop());
        Assertions.assertEquals(2, stack.pop());
        Assertions.assertEquals(1, stack.getFirst().getNext().getValue());
    }

    @Test
    void testOperationHappyPath(){
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assertions.assertEquals(5, stack.operation('+', 2, 3));
        Assertions.assertEquals(6, stack.operation('*', 2, 3));
        Assertions.assertEquals(1, stack.operation('-', 3, 2));
        Assertions.assertEquals(1, stack.operation('/', 3, 2));
        Assertions.assertEquals(1, stack.operation('%', 3, 2));
    }

    @Test
    void testPopEmptyStack(){
        Assertions.assertThrows(NullPointerException.class, () -> stack.pop());
    }

    @Test
    void testOperationInvalidOperator(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> stack.operation('a', 2, 3));
    }

    @Test
    void testOperationDivideByZero(){
        Assertions.assertThrows(ArithmeticException.class, () -> stack.operation('/', 2, 0));
    }

    @Test
    void testOperationModuloByZero(){
        Assertions.assertThrows(ArithmeticException.class, () -> stack.operation('%', 2, 0));
    }

}
    

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

import org.junit.jupiter.api.*;
public class ADTCalculatorTest {
    ADTCalculator calculator = new ADTCalculator();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    @BeforeEach
    void setUp(){
        calculator = new ADTCalculator();
        System.setOut(new PrintStream(outContent));
    }
    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        outContent.reset();
    }
    
    @Test
    void testSimpleAddition(){
        calculator.calculate("test6.txt");
        assertTrue(outContent.toString().contains("The result of the line (1 3 +) is: 4"));
    }
    @Test
    void testSimpleSubtraction(){
        calculator.calculate("test2.txt");
    }

    @Test
    void testSimpleModulo(){
        calculator.calculate("test5.txt");
    }
    @AfterAll
    void cleanUp(){
        for(int i = 2; i <= 9; i++){
            new File("test" + i + ".txt").delete();
        }
    }

}
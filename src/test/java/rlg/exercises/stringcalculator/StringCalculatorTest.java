package rlg.exercises.stringcalculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * https://blog.codeleak.pl/2013/07/3-ways-of-handling-exceptions-in-junit.html
 */
public class StringCalculatorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void testEmptyString() throws Exception {

        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void testOneNumber() throws Exception {

        assertEquals(2, stringCalculator.add("2"));
    }

    @Test
    public void testTwoNumbers() throws Exception {

        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void testNewLineBetweenNumbers() throws Exception {

        assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void testNewDelimiter() throws Exception {

        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    public void testNegatives() throws Exception {

        //One way
        // arrange
        thrown.expect(Exception.class);
        thrown.expectMessage("negatives not allowed: [-2, -3]");
        // act
        stringCalculator.add("1,-2,-3");

        //Second way
        assertThrows(Exception.class,
                    () -> stringCalculator.add("1,-2,-3"));

        //Third way
        assertThrows("negatives not allowed: [-2, -3]",
                        Exception.class,
                        () -> stringCalculator.add("1,-2,-3"));
    }

    @Test
    public void testIgnoreGreaterThan1000() throws Exception {

        assertEquals(2, stringCalculator.add("2,1001"));
    }

    @Test
    public void testComplexDelimiter() throws Exception {

        assertEquals(6, stringCalculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void testMultipleComplexDelimiters() throws Exception {

        assertEquals(15, stringCalculator.add("//[***][..]\n1***2***3..4..5"));
    }

    @Test
    public void testInvalid() throws Exception {

        assertEquals(1, stringCalculator.add("1,\n"));
    }

}

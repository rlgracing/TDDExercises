package rlg.exercises.buzzfizz;

import org.junit.Test;

import static org.junit.Assert.*;

public class BuzzFizzTest {

    private BuzzFizz buzzFizz = new BuzzFizz();

    @Test
    public void testDivisibleByThree() {
        assertTrue(DivisibleValidator.isDivisible(3, 3));
        assertTrue(DivisibleValidator.isDivisible(15, 3));
    }

    @Test
    public void testNotDivisibleByThree() {
        assertFalse(DivisibleValidator.isDivisible(2, 3));
    }

    @Test
    public void testDivisibleByFive() {
        assertTrue(DivisibleValidator.isDivisible(5, 5));
        assertTrue(DivisibleValidator.isDivisible(15, 5));
    }

    @Test
    public void testNotDivisibleByFive() {
        assertFalse(DivisibleValidator.isDivisible(2, 5));
    }

    @Test
    public void testFizz() {
        assertEquals(BuzzFizz.FIZZ, buzzFizz.process(3));
        assertEquals(BuzzFizz.FIZZ, buzzFizz.process(6));
        assertEquals(BuzzFizz.FIZZ, buzzFizz.process(9));
    }

    @Test
    public void testBuzz() {
        assertEquals(BuzzFizz.BUZZ, buzzFizz.process(5));
        assertEquals(BuzzFizz.BUZZ, buzzFizz.process(10));
        assertEquals(BuzzFizz.BUZZ, buzzFizz.process(20));
    }

    @Test
    public void testFizzBuzz() {
        String fizzBuzz = BuzzFizz.FIZZ + BuzzFizz.BUZZ;

        assertEquals(fizzBuzz, buzzFizz.process(15));
        assertEquals(fizzBuzz, buzzFizz.process(30));
    }

    @Test
    public void testNotFizzBuzz() {
        assertEquals("1", buzzFizz.process(1));
        assertEquals("2", buzzFizz.process(2));
        assertEquals("4", buzzFizz.process(4));
        assertEquals("7", buzzFizz.process(7));
    }

}

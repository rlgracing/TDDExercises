package rlg.exercises.greeting;

import org.junit.Test;
import static org.junit.Assert.*;

public class GreetingTest {

    private Greeting greeting = new Greeting();

    @Test
    public void testGreetRequirement1() {
        assertEquals("Hello, Bob.", greeting.greet("Bob"));
    }

    @Test
    public void testGreetRequirement2() {
        assertEquals("Hello, my friend.", greeting.greet(null));
    }

    @Test
    public void testGreetRequirement3() {
        assertEquals("HELLO JERRY!", greeting.greet("JERRY"));
    }

    @Test
    public void testGreetRequirement4() {
        assertEquals("Hello, Jill and Jane.", greeting.greet("Jill", "Jane"));
    }

    @Test
    public void testGreetRequirement5() {
        assertEquals("Hello, Amy, Brian and Charlotte.", greeting.greet("Amy", "Brian", "Charlotte"));
    }

    @Test
    public void testGreetRequirement6() {
        assertEquals("Hello, Amy and Charlotte. AND HELLO BRIAN!", greeting.greet("Amy", "BRIAN", "Charlotte"));
    }

    @Test
    public void testGreetRequirement7() {
        assertEquals("Hello, Bob, Charlie and Dianne.", greeting.greet("Bob", "Charlie, Dianne"));
    }

    @Test
    public void testGreetRequirement8() {
        assertEquals("Hello, Bob and Charlie, Dianne.", greeting.greet("Bob", "\"Charlie, Dianne\""));
    }
}

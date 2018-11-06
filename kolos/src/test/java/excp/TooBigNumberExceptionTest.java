package excp;

import appl.Calculator;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.Test;


public class TooBigNumberExceptionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void ordinaryTest() {
        //not throws anything - O.K.
    }

    @Test
    public void throwsTooBigNumbersException() throws TooBigNumberException, FactorialFromNegative {
        thrown.expect(TooBigNumberException.class);
        Calculator c = new Calculator();
        c.factorial(123);
    }
}

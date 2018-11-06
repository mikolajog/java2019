package appl;

import excp.DivideByZero;
import excp.FactorialFromNegative;
import excp.TooBigNumberException;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTests {
    @Test
    public void testAdd(){
        Calculator c = new Calculator();
        double res = 1.2;
        c.add(1.2);
        Assert.assertEquals("ja dodajemy 1.2 to mamy 1.2", 1.2, c.getResult(), 0.1);

    }
    @Test
    public void testSubtract(){
        Calculator c = new Calculator();
        double res = -1.2;
        c.subtract(1.2);
        Assert.assertEquals("ja odejmujemy 1.2 to mamy -1.2", res, c.getResult(), 0.1);

    }
    @Test
    public void testMultiply(){
        Calculator c = new Calculator();
        double res = 6.0;
        c.add(1.2);
        c.multiply(5);
        Assert.assertEquals("ja mnozymy 1.2 przez 5 to mamy 6", res, c.getResult(), 0.1);
    }
    @Test
    public void testDivide() throws DivideByZero {
        Calculator c = new Calculator();
        double res = 2.0;
        c.add(1.2);
        c.divide(0.6);
        Assert.assertEquals("ja dzielimy 1.2 przez 0.6 to mamy 2", res, c.getResult(), 0.1);
    }
    @Test
    public void testFactorial() throws TooBigNumberException, FactorialFromNegative {
        Calculator c = new Calculator();
        double res = 6.0;
        c.factorial(3);
        Assert.assertEquals("silnia z 3 to 6", res, c.getResult(), 0.1);
    }
}

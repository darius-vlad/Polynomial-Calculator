package Tests;

import BusinessLogic.Operations;
import DataModels.Polynomial;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperationsTest {

    @Test
    public void addTest1()
    {
        Polynomial polynom1 = new Polynomial("4x^5-3x^4+x^2-8x+1");
        Polynomial polynom2 = new Polynomial("3x^4-x^3+x^2+2x-1");
        Polynomial result = Operations.add(polynom1,polynom2);
        Polynomial expected = new Polynomial("4x^5-x^3+2x^2-6x");
        assertEquals(expected.toString(),result.toString());

    }

    @Test
    public void addTest2()
    {
        Polynomial polynom1 = new Polynomial("2x^2+2x+x+2");
        Polynomial polynom2 = new Polynomial("3x^2-5x-1");
        Polynomial result = Operations.add(polynom1,polynom2);
        Polynomial expected = new Polynomial("5x^2-2x+1");
        assertEquals(expected.toString(),result.toString());
    }

    @Test
    public void subtractTest1()
    {
        Polynomial polynom1 = new Polynomial("4x^5-3x^4+x^2-8x+1");
        Polynomial polynom2 = new Polynomial("3x^4-x^3+x^2+2x-1");
        Polynomial result = Operations.subtract(polynom1,polynom2);
        Polynomial expected = new Polynomial("4x^5-6x^4+x^3-10x+2");
        assertEquals(expected.toString(),result.toString());
    }

    @Test
    public void subtractTest2()
    {
        Polynomial polynom1 = new Polynomial("5x^2-14x-15");
        Polynomial polynom2 = new Polynomial("4x^2+8x+10");
        Polynomial result = Operations.subtract(polynom1,polynom2);
        Polynomial expected = new Polynomial("x^2-22x-25");
        assertEquals(expected.toString(),result.toString());
    }

    @Test
    public void multiplyTest1()
    {
        Polynomial polynom1 = new Polynomial("3x^2-x+1");
        Polynomial polynom2 = new Polynomial("X-2");
        Polynomial result = Operations.multiply(polynom1,polynom2);
        Polynomial expected = new Polynomial("3x^3-7x^2+3x-2");
        assertEquals(expected.toString(),result.toString());
    }

    @Test
    public void multiplyTest2()
    {
        Polynomial polynom1 = new Polynomial("7x^2+8x+2");
        Polynomial polynom2 = new Polynomial("8x^2+6x+5");
        Polynomial result = Operations.multiply(polynom1,polynom2);
        Polynomial expected = new Polynomial("56x^4+106x^3+99x^2+52x+10");
        assertEquals(expected.toString(),result.toString());
    }


 @Test
    public void divisionTest1()
    {
        Polynomial polynom1 = new Polynomial("x^3-2x^2+6x-5");
        Polynomial polynom2 = new Polynomial("x^2-1");
        ArrayList<Polynomial> results = Operations.divide(polynom1,polynom2);
        Polynomial expectedQuotient = new Polynomial("x-2");
        Polynomial expectedRemainder = new Polynomial("7x-7");
        assertTrue(results.get(0).toString().equals(expectedQuotient.toString()) && results.get(1).toString().equals(expectedRemainder.toString()));

    }

    @Test
    public void divisionTest2()
    {
        Polynomial polynom1 = new Polynomial("x^2+9x+20");
        Polynomial polynom2 = new Polynomial("x+5");
        ArrayList<Polynomial> results = Operations.divide(polynom1,polynom2);
        Polynomial expectedQuotient= new Polynomial("x+4");
        Polynomial expectedRemainder = new Polynomial("0");
        assertTrue(results.get(0).toString().equals(expectedQuotient.toString()) && results.get(1).toString().equals(expectedRemainder.toString()));
    }

    @Test
    public void derivativeTest1()
    {
        Polynomial polynom = new Polynomial("x^3-2x^2+6x-5");
        Polynomial result = Operations.derivatePolynomial(polynom);
        Polynomial expected = new Polynomial("3x^2-4x+6");
        assertEquals(expected.toString(),result.toString());
    }

    @Test
    public void derivativeTest2()
    {
        Polynomial polynom = new Polynomial("5X^4-6X^2+3X-4");
        Polynomial result = Operations.derivatePolynomial(polynom);
        Polynomial expected = new Polynomial("20x^3-12x+3");
        assertEquals(expected.toString(),result.toString());
    }

    @Test
    public void integrationTest1()
    {
        Polynomial polynom = new Polynomial("x^3+4x^2+x");
        Polynomial result = Operations.integratePolynomial(polynom);
        Polynomial expected = new Polynomial("0.25x^4+1.33x^3+0.50x^2");
        assertEquals(expected.toString(),result.toString());
    }

    @Test
    public void integrationTest2()
    {
        Polynomial polynom = new Polynomial("5x^4-2x^2+3");
        Polynomial result = Operations.integratePolynomial(polynom);
        Polynomial expected = new Polynomial("x^5-0.67x^3+3x");
        assertEquals(expected.toString(),result.toString());
    }
}

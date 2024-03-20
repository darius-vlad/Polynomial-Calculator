package BusinessLogic;

import DataModels.Monomial;
import DataModels.MonomialWithDoubleCoefficient;
import DataModels.MonomialWithIntegerCoefficient;
import DataModels.Polynomial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Operations {

    public static Polynomial add(Polynomial polynom1, Polynomial polynom2) {
        Polynomial result = new Polynomial();
        for (Integer key : polynom1.getMonomials().keySet()) {
            result.addMonomial(polynom1.getMonomials().get(key));
        }

        for (Integer key : polynom2.getMonomials().keySet()) {

            if (result.getMonomials().get(key) == null)
                result.addMonomial(polynom2.getMonomials().get(key));
            else {
                int coef = result.getMonomials().get(key).getCoefficient().intValue();
                coef += polynom2.getMonomials().get(key).getCoefficient().intValue();
                result.getMonomials().get(key).setCoefficient(coef);
            }


        }

        Iterator<Map.Entry<Integer, Monomial>> iterator = result.getMonomials().entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue().getCoefficient().intValue() == 0)
                iterator.remove();
        }

        return result;
    }


    public static Polynomial subtract(Polynomial polynom1, Polynomial polynom2) {
        Polynomial result = new Polynomial();
        for (Integer key : polynom1.getMonomials().keySet()) {
            result.addMonomial(polynom1.getMonomials().get(key));
        }

        for (Integer key : polynom2.getMonomials().keySet()) {

            if (result.getMonomials().get(key) == null) {
                Monomial m = polynom2.getMonomials().get(key);
                int coefficient = m.getCoefficient().intValue();
                m.setCoefficient(-coefficient);
                result.addMonomial(m);
            } else {
                int coefficient = result.getMonomials().get(key).getCoefficient().intValue();
                coefficient -= polynom2.getMonomials().get(key).getCoefficient().intValue();
                result.getMonomials().get(key).setCoefficient(coefficient);
            }


        }
        Iterator<Map.Entry<Integer, Monomial>> iterator = result.getMonomials().entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue().getCoefficient().intValue() == 0)
                iterator.remove();
        }

        return result;
    }


    public static Polynomial multiply(Polynomial polynom1, Polynomial polynom2) {
        int degree, coef;
        Polynomial result = new Polynomial();
        for (Integer key1 : polynom1.getMonomials().keySet())
            for (Integer key2 : polynom2.getMonomials().keySet()) {
                Monomial m1 = polynom1.getMonomials().get(key1);
                Monomial m2 = polynom2.getMonomials().get(key2);
                coef = m1.getCoefficient().intValue() * m2.getCoefficient().intValue();
                degree = m1.getDegree() + m2.getDegree();
                MonomialWithIntegerCoefficient mresult = new MonomialWithIntegerCoefficient(degree, coef);
                if (result.getMonomials().get(degree) != null) {
                    int coefficient = result.getMonomials().get(degree).getCoefficient().intValue();
                    coefficient += mresult.getCoefficient().intValue();
                    result.getMonomials().get(degree).setCoefficient(coefficient);
                } else
                    result.addMonomial(mresult);

            }

        return result;
    }

    public static ArrayList<Polynomial> divide(Polynomial polynom1, Polynomial polynom2) {
        Polynomial quotient = new Polynomial();
        ArrayList<Polynomial> results = new ArrayList<>();
        while (!polynom1.getMonomials().isEmpty() && polynom1.getMonomials().get(polynom1.getMonomials().firstKey()).getDegree() >= polynom2.getMonomials().get(polynom2.getMonomials().firstKey()).getDegree()) {
            double coefficient;
            if (polynom1.getMonomials().get(polynom1.getMonomials().firstKey()).getCoefficient().intValue() % polynom2.getMonomials().get(polynom2.getMonomials().firstKey()).getCoefficient().intValue() == 0) {

                int coefInt = 0;
                coefInt = polynom1.getMonomials().get(polynom1.getMonomials().firstKey()).getCoefficient().intValue() / polynom2.getMonomials().get(polynom2.getMonomials().firstKey()).getCoefficient().intValue();
                int degree = polynom1.getMonomials().get(polynom1.getMonomials().firstKey()).getDegree() - polynom2.getMonomials().get(polynom2.getMonomials().firstKey()).getDegree();
                Monomial mq = new MonomialWithIntegerCoefficient(degree, coefInt);
                Polynomial onlyOneMonomial = new Polynomial();
                onlyOneMonomial.addMonomial(mq);
                quotient.addMonomial(mq);
                Polynomial polynomToSubtract = Operations.multiply(onlyOneMonomial, polynom2);
                polynom1 = Operations.subtract(polynom1, polynomToSubtract);

            } else {

                coefficient = (double) polynom1.getMonomials().get(polynom1.getMonomials().firstKey()).getCoefficient().intValue() / polynom2.getMonomials().get(polynom2.getMonomials().firstKey()).getCoefficient().intValue();
                int degree = polynom1.getMonomials().get(polynom1.getMonomials().firstKey()).getDegree() - polynom2.getMonomials().get(polynom2.getMonomials().firstKey()).getDegree();
                Monomial mq = new MonomialWithDoubleCoefficient(degree, coefficient);
                Polynomial onlyOneMonomial = new Polynomial();
                onlyOneMonomial.addMonomial(mq);
                quotient.addMonomial(mq);
                Polynomial polynomToSubtract = Operations.multiplyPolynamialsWithDoubleCoefficient(onlyOneMonomial, polynom2);
                polynom1 = Operations.subtractPolynomialsWithDoubleCoefficients(polynom1, polynomToSubtract);

            }
        }
        results.add(quotient);
        results.add(polynom1);
        return results;
    }


    public static Polynomial derivatePolynomial(Polynomial polynomial1) {
        Polynomial result = new Polynomial();
        for (Integer key : polynomial1.getMonomials().keySet()) {
            int degreeOfResult;
            int coefficientOfResult;

            coefficientOfResult = polynomial1.getMonomials().get(key).getDegree() * polynomial1.getMonomials().get(key).getCoefficient().intValue();
            degreeOfResult = polynomial1.getMonomials().get(key).getDegree() - 1;
            if (degreeOfResult != -1) {
                MonomialWithIntegerCoefficient mresult = new MonomialWithIntegerCoefficient(degreeOfResult, coefficientOfResult);
                result.addMonomial(mresult);
            }


        }

        return result;
    }


    public static Polynomial integratePolynomial(Polynomial polynomial1) {
        Polynomial result = new Polynomial();
        for (Integer key : polynomial1.getMonomials().keySet()) {
            int degreeOfResult;
            double coefficientOfResult;
            degreeOfResult = polynomial1.getMonomials().get(key).getDegree() + 1;
            if (polynomial1.getMonomials().get(key).getCoefficient().intValue() % degreeOfResult == 0) {
                int coefInt = 0;
                coefInt = polynomial1.getMonomials().get(key).getCoefficient().intValue() / degreeOfResult;
                MonomialWithIntegerCoefficient mresult = new MonomialWithIntegerCoefficient(degreeOfResult, coefInt);
                result.addMonomial(mresult);
            } else {
                coefficientOfResult = (double) polynomial1.getMonomials().get(key).getCoefficient().intValue() / degreeOfResult;
                MonomialWithDoubleCoefficient mresult = new MonomialWithDoubleCoefficient(degreeOfResult, coefficientOfResult);
                result.addMonomial(mresult);

            }


        }
        return result;
    }


    public static Polynomial subtractPolynomialsWithDoubleCoefficients(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (Integer key : p1.getMonomials().keySet()) {
            result.addMonomial(p1.getMonomials().get(key));
        }
        for (Integer key : p2.getMonomials().keySet()) {
            if (result.getMonomials().get(key) == null) {
                Monomial m = p2.getMonomials().get(key);
                double coefficient = m.getCoefficient().doubleValue();
                m.setCoefficient(-coefficient);
                result.addMonomial(m);
            } else {
                double coefficient = result.getMonomials().get(key).getCoefficient().doubleValue();
                coefficient -= p2.getMonomials().get(key).getCoefficient().doubleValue();
                result.getMonomials().get(key).setCoefficient(coefficient);
            }
        }
        Iterator<Map.Entry<Integer, Monomial>> iterator = result.getMonomials().entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue().getCoefficient().doubleValue() == 0)
                iterator.remove();
        }
        return result;
    }


    public static Polynomial multiplyPolynamialsWithDoubleCoefficient(Polynomial polynom1, Polynomial polynom2) {
        int degree;
        double coef;
        Polynomial result = new Polynomial();
        for (Integer key1 : polynom1.getMonomials().keySet())
            for (Integer key2 : polynom2.getMonomials().keySet()) {
                Monomial m1 = polynom1.getMonomials().get(key1);
                Monomial m2 = polynom2.getMonomials().get(key2);
                coef = m1.getCoefficient().doubleValue() * m2.getCoefficient().doubleValue();
                degree = m1.getDegree() + m2.getDegree();
                MonomialWithDoubleCoefficient mresult = new MonomialWithDoubleCoefficient(degree, coef);
                if (result.getMonomials().get(degree) != null) {
                    double coefficient = result.getMonomials().get(degree).getCoefficient().doubleValue();
                    coefficient += mresult.getCoefficient().doubleValue();
                    result.getMonomials().get(degree).setCoefficient(coefficient);
                } else
                    result.addMonomial(mresult);


            }
        return result;
    }

}

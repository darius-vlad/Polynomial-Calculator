package DataModels;

import GraphicalUserInterface.UserInterface;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private TreeMap<Integer, Monomial> monomials;


    public Polynomial() {
        monomials = new TreeMap<>(Collections.reverseOrder());
    }

    public Polynomial(String polinomial) {
        monomials = new TreeMap<>(Collections.reverseOrder());
        polinomial = polinomial.toLowerCase();
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(polinomial);
        while (matcher.find()) {
            Monomial m;
            if (matcher.group(1).contains("."))
                m = new MonomialWithDoubleCoefficient(matcher.group(1));
            else
                m = new MonomialWithIntegerCoefficient(matcher.group(1));
            this.addMonomial(m);

        }
    }


    public void addMonomial(Monomial monom) {
        int degree = monom.getDegree();
        if (monomials.get(degree) != null) {
            int coef;
            coef = monomials.get(degree).getCoefficient().intValue();
            coef += monom.getCoefficient().intValue();
            monomials.get(degree).setCoefficient(coef);
        } else
            monomials.put(degree, monom);
    }


    public String toString() {
        String s = "";
        for (Integer key : monomials.keySet()) {
            s = s + monomials.get(key);
        }
        if (s.isEmpty())
            s = "0";
        else if (s.charAt(0) == '+')
            s = s.substring(1);
        return s;
    }

    public TreeMap<Integer, Monomial> getMonomials() {
        return monomials;
    }
}

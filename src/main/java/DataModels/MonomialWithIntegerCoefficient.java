package DataModels;

public class MonomialWithIntegerCoefficient extends Monomial {

    private int coefficient;

    public MonomialWithIntegerCoefficient(int degree, int coefficient) {
        super(degree);
        this.coefficient = coefficient;
    }

    public MonomialWithIntegerCoefficient(String text) {
        super(text);
        int coef = 0;
        if (text.contains("x") && text.contains("^")) {
            if (text.charAt(0) == 'x') {
                coef = 1;
                String[] str = text.split("x", 2);
            } else {
                String[] str = text.split("x", 2);
                if (str[0].equals("+"))
                    coef = 1;
                else if (str[0].equals("-"))
                    coef = -1;
                else
                    coef = Integer.parseInt(str[0]);
            }
        } else if (text.contains("x") && !text.contains("^")) {
            if (text.charAt(0) == 'x')
                coef = 1;
            else {
                String[] str = text.split("x", 2);
                if (str[0].equals("+"))
                    coef = 1;
                else if (str[0].equals("-"))
                    coef = -1;
                else
                    coef = Integer.parseInt(str[0]);
            }
        } else {
            coef = Integer.parseInt(text);}
        this.coefficient = coef;}

    public void setCoefficient(Number coefficient) {
        this.coefficient = coefficient.intValue();
    }

    public Number getCoefficient() {
        return coefficient;
    }

    public String toString() {
        String coef = "";
        String deg = "";
        if (coefficient == 1)
            coef = coef + "+";
        else if (coefficient == -1)
            coef = coef + "-";
        else if (coefficient > 1)
            coef = coef + "+" + coefficient;
        else coef = coef + coefficient;

        if (degree > 0) {
            if (degree == 1)
                deg = "x";
            else
                deg = deg + "x^" + degree;
        } else if (degree < 0) {
            deg = deg + "x^-" + degree;
        }

        if (coefficient == 1 && degree == 0)
            coef = "+1";
        if (coefficient == -1 && degree == 0)
            coef = "-1";
        String result = coef + deg;
        return result;
    }
}

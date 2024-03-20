package DataModels;

public class MonomialWithDoubleCoefficient extends Monomial {

    private double coefficient;

    public MonomialWithDoubleCoefficient(int degree, double coefficient) {
        super(degree);
        this.coefficient = coefficient;
    }

    public MonomialWithDoubleCoefficient(String text) {
        super(text);
        double coef = 0;
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
                    coef = Double.parseDouble(str[0]);
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
                    coef = Double.parseDouble(str[0]);
            }
        } else {
            coef = Double.parseDouble(text);}
        this.coefficient = coef;}

    public Number getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Number coefficient) {
        this.coefficient = coefficient.doubleValue();
    }

    public String toString() {
        String coef = "";
        String deg = "";
        if (coefficient == 1)
            coef = coef + "+";
        else if (coefficient == -1)
            coef = coef + "-";
        else if (coefficient > 1)
            coef = coef + "+" + String.format("%.2f", coefficient);
        else coef = coef + String.format("%.2f", coefficient);

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

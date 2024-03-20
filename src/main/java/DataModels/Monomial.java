package DataModels;

public abstract class Monomial {
    int degree;

    public Monomial(int degree) {
        this.degree = degree;
    }

    public Monomial(String text) {
        int degree = 0;
        if (text.contains("x") && text.contains("^")) {
            String[] str = text.split("x", 2);
            degree = Integer.parseInt(str[1].substring(1));
        } else if (text.contains("x") && !text.contains("^")) {
            degree = 1;
        } else {
            degree = 0;
        }
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }

    public abstract Number getCoefficient();

    public abstract void setCoefficient(Number coefficient);

    public abstract String toString();
}

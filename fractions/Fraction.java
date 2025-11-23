package fractions;

public class Fraction implements IFraction {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    @Override
    public double getValue() {
        return (double) numerator / denominator;
    }

    @Override
    public void setNumerator(int num) {
        this.numerator = num;
    }

    @Override
    public void setDenominator(int den) {
        if (den == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть нулём.");
        }
        if (den < 0) {
            numerator = -numerator;
            den = -den;
        }
        this.denominator = den;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Fraction f)) {
            return false;
        }
        return numerator == f.numerator && denominator == f.denominator;
    }

    @Override
    public int hashCode() {
        return numerator * 31 + denominator;
    }
}

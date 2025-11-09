import java.util.Objects;

public class Fraction implements IFraction {
    private int numerator;
    private int denominator;
    private Double cachedValue;

    public Fraction() {
        this(0, 1);
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю!");
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
        this.cachedValue = null;
    }

    @Override
    public double getValue() {
        if (cachedValue == null) {
            cachedValue = (double) numerator / denominator;
        }
        return cachedValue;
    }

    @Override
    public void setNumerator(int num) {
        this.numerator = num;
        this.cachedValue = null; // сбрасываем кэш
    }

    @Override
    public void setDenominator(int den) {
        if (den == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю!");
        }
        if (den < 0) {
            numerator = -numerator;
            den = -den;
        }
        this.denominator = den;
        this.cachedValue = null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fraction)) return false;
        Fraction other = (Fraction) obj;
        return numerator == other.numerator && denominator == other.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator + " = " + getValue();
    }
}

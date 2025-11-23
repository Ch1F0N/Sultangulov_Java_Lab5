package fractions;

public class CachedFraction implements IFraction {

    private final IFraction fraction;
    private Double cachedValue = null;

    public CachedFraction(IFraction fraction) {
        this.fraction = fraction;
    }

    @Override
    public double getValue() {
        if (cachedValue == null) {
            cachedValue = fraction.getValue();
        }
        return cachedValue;
    }

    @Override
    public void setNumerator(int num) {
        fraction.setNumerator(num);
        cachedValue = null;
    }

    @Override
    public void setDenominator(int den) {
        fraction.setDenominator(den);
        cachedValue = null;
    }

    @Override
    public String toString() {
        return fraction.toString() + " = " + getValue();
    }
}

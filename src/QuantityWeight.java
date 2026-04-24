public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    public double toBase() {
        return unit.convertToBaseUnit(value); // kg
    }

    // ✅ Conversion
    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");

        double base = this.toBase();
        double converted = targetUnit.convertFromBaseUnit(base);

        return new QuantityWeight(converted, targetUnit);
    }

    // ✅ Addition (default)
    public QuantityWeight add(QuantityWeight other) {
        return add(other, this.unit);
    }

    // ✅ Addition (target unit)
    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {

        if (other == null) throw new IllegalArgumentException("Quantity cannot be null");
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");

        double sumBase = this.toBase() + other.toBase();

        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new QuantityWeight(result, targetUnit);
    }

    // ✅ Equality
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof QuantityWeight)) return false;

        QuantityWeight other = (QuantityWeight) obj;

        return Math.abs(this.toBase() - other.toBase()) < 1e-6;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(toBase());
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}
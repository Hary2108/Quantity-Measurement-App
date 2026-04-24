public class Quantity {

    private final double value;
    private final LengthUnit unit;

    public Quantity(double value, LengthUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // 🔹 Convert current value to base (feet)
    public double toBase() {
        return unit.convertToBaseUnit(value);
    }

    // 🔹 UC5 Conversion
    public Quantity convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");

        double base = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(base);

        return new Quantity(converted, targetUnit);
    }

    // 🔹 UC6 Addition (default → first unit)
    public Quantity add(Quantity other) {
        return add(other, this.unit);
    }

    // 🔥 UC7 Addition (with target unit)
    public Quantity add(Quantity other, LengthUnit targetUnit) {

        if (other == null) throw new IllegalArgumentException("Quantity cannot be null");
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");

        double sumBase = this.toBase() + other.toBase();

        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new Quantity(result, targetUnit);
    }

    // 🔹 Equality (UC4)
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof Quantity)) return false;

        Quantity other = (Quantity) obj;

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
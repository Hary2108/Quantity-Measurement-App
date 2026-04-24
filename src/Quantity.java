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

    public double toFeet() {
        return unit.toFeet(value);
    }

    // 🔹 UC5
    public static double convert(double value, LengthUnit source, LengthUnit target) {
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");
        if (source == null || target == null) throw new IllegalArgumentException("Units cannot be null");

        double inFeet = source.toFeet(value);
        return target.fromFeet(inFeet);
    }

    public Quantity convertTo(LengthUnit target) {
        return new Quantity(convert(value, unit, target), target);
    }

    // 🔹 UC6 (default: first operand unit)
    public static Quantity add(Quantity q1, Quantity q2) {
        return add(q1, q2, q1.unit);
    }

    // 🔥 UC7 (MAIN FEATURE)
    public static Quantity add(Quantity q1, Quantity q2, LengthUnit targetUnit) {

        if (q1 == null || q2 == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double sumFeet = q1.toFeet() + q2.toFeet();

        double resultValue = targetUnit.fromFeet(sumFeet);

        return new Quantity(resultValue, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity)) return false;

        Quantity other = (Quantity) obj;
        return Math.abs(this.toFeet() - other.toFeet()) < 1e-6;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(toFeet());
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}
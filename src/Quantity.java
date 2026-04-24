public class Quantity {

    private final double value;
    private final LengthUnit unit;

    public Quantity(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
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

    // ✅ UC5 Conversion
    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        double inFeet = source.toFeet(value);
        return target.fromFeet(inFeet);
    }

    public Quantity convertTo(LengthUnit target) {
        double convertedValue = convert(this.value, this.unit, target);
        return new Quantity(convertedValue, target);
    }
    // ✅ UC6 Addition
    public static Quantity add(Quantity q1, Quantity q2) {

        if (q1 == null || q2 == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }

        double q1Feet = q1.toFeet();
        double q2Feet = q2.toFeet();

        double sumFeet = q1Feet + q2Feet;

        double resultValue = q1.unit.fromFeet(sumFeet);

        return new Quantity(resultValue, q1.unit);
    }

    public Quantity add(Quantity other) {
        return add(this, other);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

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
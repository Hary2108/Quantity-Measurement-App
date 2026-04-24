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

    public double toFeet() {
        return unit.toFeet(value);
    }

    // ✅ UC5 MAIN METHOD
    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        double inFeet = source.toFeet(value);      // Step 1
        return target.fromFeet(inFeet);            // Step 2
    }

    // ✅ OPTIONAL (for extra marks)
    public Quantity convertTo(LengthUnit target) {
        double convertedValue = convert(this.value, this.unit, target);
        return new Quantity(convertedValue, target);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Quantity other = (Quantity) obj;

        // ✅ FIXED (floating precision safe)
        return Math.abs(this.toFeet() - other.toFeet()) < 1e-6;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(toFeet());
    }
}
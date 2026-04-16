public class Quantity {

    private final double value;
    private final LengthUnit unit;

    public Quantity(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    public double toFeet() {
        return unit.toFeet(value);
    }

    @Override
    public boolean equals(Object obj) {

        // Reflexive
        if (this == obj) return true;

        // Null + Type check
        if (obj == null || getClass() != obj.getClass()) return false;

        Quantity other = (Quantity) obj;

        // Compare after converting to common unit
        return Double.compare(this.toFeet(), other.toFeet()) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(toFeet());
    }
}
public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // Conversion
        System.out.println(new Quantity(1.0, LengthUnit.FEET)
                .convertTo(LengthUnit.INCH)); // 12 INCH

        // Addition (default)
        System.out.println(new Quantity(1.0, LengthUnit.FEET)
                .add(new Quantity(12.0, LengthUnit.INCH))); // 2 FEET

        // Addition with target unit (UC7)
        System.out.println(new Quantity(1.0, LengthUnit.FEET)
                .add(new Quantity(12.0, LengthUnit.INCH), LengthUnit.YARD)); // ~0.667 YARD

        // Equality
        System.out.println(new Quantity(36.0, LengthUnit.INCH)
                .equals(new Quantity(1.0, LengthUnit.YARD))); // true
    }
}
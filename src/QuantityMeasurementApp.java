public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // Existing UC4 checks
        System.out.println(
                new Quantity(1.0, LengthUnit.YARD)
                        .equals(new Quantity(3.0, LengthUnit.FEET))
        );

        // ✅ UC5 conversions
        System.out.println(Quantity.convert(1.0, LengthUnit.FEET, LengthUnit.INCH)); // 12.0
        System.out.println(Quantity.convert(24.0, LengthUnit.INCH, LengthUnit.FEET)); // 2.0
        System.out.println(Quantity.convert(1.0, LengthUnit.YARD, LengthUnit.INCH)); // 36.0
        System.out.println(Quantity.convert(2.54, LengthUnit.CENTIMETER, LengthUnit.INCH)); // ~1.0
    }
}
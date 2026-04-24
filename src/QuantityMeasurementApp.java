public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // UC4 Equality
        System.out.println(new Quantity(1.0, LengthUnit.YARD)
                .equals(new Quantity(3.0, LengthUnit.FEET)));

        // UC5 Conversion
        System.out.println(Quantity.convert(1.0, LengthUnit.FEET, LengthUnit.INCH));

        // UC6 Addition
        Quantity result = Quantity.add(
                new Quantity(1.0, LengthUnit.FEET),
                new Quantity(12.0, LengthUnit.INCH)
        );
        System.out.println(result); // Expected: 2.0 FEET
    }
}
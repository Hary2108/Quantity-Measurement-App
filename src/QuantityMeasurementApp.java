public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // UC7 Example
        Quantity result1 = Quantity.add(
                new Quantity(1.0, LengthUnit.FEET),
                new Quantity(12.0, LengthUnit.INCH),
                LengthUnit.FEET
        );

        Quantity result2 = Quantity.add(
                new Quantity(1.0, LengthUnit.FEET),
                new Quantity(12.0, LengthUnit.INCH),
                LengthUnit.INCH
        );

        Quantity result3 = Quantity.add(
                new Quantity(1.0, LengthUnit.FEET),
                new Quantity(12.0, LengthUnit.INCH),
                LengthUnit.YARD
        );

        System.out.println(result1); // 2 FEET
        System.out.println(result2); // 24 INCH
        System.out.println(result3); // ~0.667 YARD
    }
}
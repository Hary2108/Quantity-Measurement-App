public class QuantityMeasurementApp {

    public static void main(String[] args) {

        System.out.println(
                new Quantity(1.0, LengthUnit.YARD)
                        .equals(new Quantity(3.0, LengthUnit.FEET))
        ); // true

        System.out.println(
                new Quantity(1.0, LengthUnit.YARD)
                        .equals(new Quantity(36.0, LengthUnit.INCH))
        ); // true

        System.out.println(
                new Quantity(1.0, LengthUnit.CENTIMETER)
                        .equals(new Quantity(0.393701, LengthUnit.INCH))
        ); // true
    }
}
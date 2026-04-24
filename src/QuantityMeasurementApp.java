public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // 🔹 LENGTH (existing)
        System.out.println(new Quantity(1.0, LengthUnit.FEET)
                .convertTo(LengthUnit.INCH));

        // 🔹 WEIGHT (NEW)
        System.out.println(new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                .equals(new QuantityWeight(1000.0, WeightUnit.GRAM)));

        System.out.println(new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                .convertTo(WeightUnit.POUND));

        System.out.println(new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                .add(new QuantityWeight(1000.0, WeightUnit.GRAM)));

        System.out.println(new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                .add(new QuantityWeight(1000.0, WeightUnit.GRAM), WeightUnit.GRAM));
    }
}
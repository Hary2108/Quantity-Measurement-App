import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testWeightEquality_KgToGram() {
        assertTrue(new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                .equals(new QuantityWeight(1000.0, WeightUnit.GRAM)));
    }

    @Test
    public void testWeightConversion_KgToPound() {
        QuantityWeight q = new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                .convertTo(WeightUnit.POUND);

        assertEquals(2.20462, q.getValue(), 0.01);
    }

    @Test
    public void testWeightAddition_Default() {
        QuantityWeight result = new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                .add(new QuantityWeight(1000.0, WeightUnit.GRAM));

        assertEquals(2.0, result.getValue(), 0.0001);
    }

    @Test
    public void testWeightAddition_TargetUnit() {
        QuantityWeight result = new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                .add(new QuantityWeight(1000.0, WeightUnit.GRAM), WeightUnit.GRAM);

        assertEquals(2000.0, result.getValue(), 0.0001);
    }

    @Test
    public void testWeightVsLength_NotEqual() {
        assertFalse(new QuantityWeight(1.0, WeightUnit.KILOGRAM)
                .equals(new Quantity(1.0, LengthUnit.FEET)));
    }
}
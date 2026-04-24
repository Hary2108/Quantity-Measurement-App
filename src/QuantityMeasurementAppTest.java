import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testConvert_FeetToInch() {
        Quantity q = new Quantity(1.0, LengthUnit.FEET)
                .convertTo(LengthUnit.INCH);

        assertEquals(12.0, q.getValue(), 0.0001);
    }

    @Test
    public void testAddition_DefaultUnit() {
        Quantity result = new Quantity(1.0, LengthUnit.FEET)
                .add(new Quantity(12.0, LengthUnit.INCH));

        assertEquals(2.0, result.getValue(), 0.0001);
    }

    @Test
    public void testAddition_TargetUnit() {
        Quantity result = new Quantity(1.0, LengthUnit.FEET)
                .add(new Quantity(12.0, LengthUnit.INCH), LengthUnit.YARD);

        assertEquals(0.6667, result.getValue(), 0.01);
    }

    @Test
    public void testEquality() {
        assertTrue(new Quantity(36.0, LengthUnit.INCH)
                .equals(new Quantity(1.0, LengthUnit.YARD)));
    }

    @Test
    public void testNullUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                new Quantity(1.0, null));
    }
}
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testAddition_TargetFeet() {
        Quantity result = Quantity.add(
                new Quantity(1.0, LengthUnit.FEET),
                new Quantity(12.0, LengthUnit.INCH),
                LengthUnit.FEET
        );
        assertEquals(2.0, result.getValue(), 0.0001);
    }

    @Test
    public void testAddition_TargetInch() {
        Quantity result = Quantity.add(
                new Quantity(1.0, LengthUnit.FEET),
                new Quantity(12.0, LengthUnit.INCH),
                LengthUnit.INCH
        );
        assertEquals(24.0, result.getValue(), 0.0001);
    }

    @Test
    public void testAddition_TargetYard() {
        Quantity result = Quantity.add(
                new Quantity(1.0, LengthUnit.FEET),
                new Quantity(12.0, LengthUnit.INCH),
                LengthUnit.YARD
        );
        assertEquals(0.6667, result.getValue(), 0.01);
    }

    @Test
    public void testAddition_NullTarget() {
        assertThrows(IllegalArgumentException.class, () ->
                Quantity.add(
                        new Quantity(1.0, LengthUnit.FEET),
                        new Quantity(12.0, LengthUnit.INCH),
                        null
                )
        );
    }

    @Test
    public void testAddition_Commutative() {
        Quantity r1 = Quantity.add(
                new Quantity(1.0, LengthUnit.FEET),
                new Quantity(12.0, LengthUnit.INCH),
                LengthUnit.YARD
        );

        Quantity r2 = Quantity.add(
                new Quantity(12.0, LengthUnit.INCH),
                new Quantity(1.0, LengthUnit.FEET),
                LengthUnit.YARD
        );

        assertEquals(r1.getValue(), r2.getValue(), 0.0001);
    }
}
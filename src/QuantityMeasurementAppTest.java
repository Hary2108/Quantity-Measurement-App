import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ✅ UC4 Tests
    @Test
    public void testEquality_YardToFeet() {
        assertTrue(new Quantity(1.0, LengthUnit.YARD)
                .equals(new Quantity(3.0, LengthUnit.FEET)));
    }

    // ✅ UC5 Tests
    @Test
    public void testConversion_FeetToInch() {
        assertEquals(12.0, Quantity.convert(1.0, LengthUnit.FEET, LengthUnit.INCH), 0.0001);
    }

    @Test
    public void testConversion_InchToFeet() {
        assertEquals(2.0, Quantity.convert(24.0, LengthUnit.INCH, LengthUnit.FEET), 0.0001);
    }

    // ✅ UC6 Tests
    @Test
    public void testAddition_FeetPlusFeet() {
        Quantity result = Quantity.add(
                new Quantity(1.0, LengthUnit.FEET),
                new Quantity(2.0, LengthUnit.FEET)
        );
        assertEquals(3.0, result.toFeet(), 0.0001);
    }
    @Test
    public void testAddition_FeetPlusInch() {
        Quantity result = Quantity.add(
                new Quantity(1.0, LengthUnit.FEET),
                new Quantity(12.0, LengthUnit.INCH)
        );
        assertEquals(2.0, result.toFeet(), 0.0001);
    }

    @Test
    public void testAddition_WithZero() {
        Quantity result = Quantity.add(
                new Quantity(5.0, LengthUnit.FEET),
                new Quantity(0.0, LengthUnit.INCH)
        );
        assertEquals(5.0, result.toFeet(), 0.0001);
    }

    @Test
    public void testAddition_Negative() {
        Quantity result = Quantity.add(
                new Quantity(5.0, LengthUnit.FEET),
                new Quantity(-2.0, LengthUnit.FEET)
        );
        assertEquals(3.0, result.toFeet(), 0.0001);
    }
}
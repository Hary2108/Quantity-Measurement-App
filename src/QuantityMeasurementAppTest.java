import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testConversion_FeetToInch() {
        assertEquals(12.0, Quantity.convert(1.0, LengthUnit.FEET, LengthUnit.INCH), 0.0001);
    }

    @Test
    public void testConversion_InchToFeet() {
        assertEquals(2.0, Quantity.convert(24.0, LengthUnit.INCH, LengthUnit.FEET), 0.0001);
    }
    @Test
    public void testConversion_YardToInch() {
        assertEquals(36.0, Quantity.convert(1.0, LengthUnit.YARD, LengthUnit.INCH), 0.0001);
    }
    @Test
    public void testConversion_CentimeterToInch() {
        assertEquals(1.0, Quantity.convert(2.54, LengthUnit.CENTIMETER, LengthUnit.INCH), 0.0001);
    }
    @Test
    public void testConversion_Zero() {
        assertEquals(0.0, Quantity.convert(0.0, LengthUnit.FEET, LengthUnit.INCH), 0.0001);
    }

    @Test
    public void testConversion_Negative() {
        assertEquals(-12.0, Quantity.convert(-1.0, LengthUnit.FEET, LengthUnit.INCH), 0.0001);
    }
}
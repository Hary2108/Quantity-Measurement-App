import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        assertTrue(new Quantity(1.0, LengthUnit.YARD)
                .equals(new Quantity(3.0, LengthUnit.FEET)));
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        assertTrue(new Quantity(1.0, LengthUnit.YARD)
                .equals(new Quantity(36.0, LengthUnit.INCH)));
    }

    @Test
    public void testEquality_CentimeterToInch_EquivalentValue() {
        assertTrue(new Quantity(1.0, LengthUnit.CENTIMETER)
                .equals(new Quantity(0.393701, LengthUnit.INCH)));
    }

    @Test
    public void testEquality_CentimeterToFeet_NonEquivalent() {
        assertFalse(new Quantity(1.0, LengthUnit.CENTIMETER)
                .equals(new Quantity(1.0, LengthUnit.FEET)));
    }

    @Test
    public void testEquality_MultiUnit_Transitive() {

        Quantity yard = new Quantity(1.0, LengthUnit.YARD);
        Quantity feet = new Quantity(3.0, LengthUnit.FEET);
        Quantity inches = new Quantity(36.0, LengthUnit.INCH);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }

    @Test
    public void testEquality_AllUnits_ComplexScenario() {

        assertTrue(new Quantity(2.0, LengthUnit.YARD)
                .equals(new Quantity(6.0, LengthUnit.FEET)));

        assertTrue(new Quantity(6.0, LengthUnit.FEET)
                .equals(new Quantity(72.0, LengthUnit.INCH)));
    }
}
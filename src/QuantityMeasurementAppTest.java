import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import QuantityMeasurementApp.Feet;
import QuantityMeasurementApp.Inches;

public class QuantityMeasurementAppTest {

    // -------- FEET TESTS --------

    @Test
    public void testFeetEquality_SameValue() {
        assertTrue(QuantityMeasurementApp.areFeetEqual(1.0, 1.0));
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        assertFalse(QuantityMeasurementApp.areFeetEqual(1.0, 2.0));
    }

    @Test
    public void testFeetEquality_NullComparison() {
        Feet f = new Feet(1.0);
        assertFalse(f.equals(null));
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        Feet f = new Feet(1.0);
        assertFalse(f.equals("string"));
    }

    @Test
    public void testFeetEquality_SameReference() {
        Feet f = new Feet(1.0);
        assertTrue(f.equals(f));
    }

    // -------- INCHES TESTS --------

    @Test
    public void testInchesEquality_SameValue() {
        assertTrue(QuantityMeasurementApp.areInchesEqual(1.0, 1.0));
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        assertFalse(QuantityMeasurementApp.areInchesEqual(1.0, 2.0));
    }

    @Test
    public void testInchesEquality_NullComparison() {
        Inches i = new Inches(1.0);
        assertFalse(i.equals(null));
    }

    @Test
    public void testInchesEquality_DifferentClass() {
        Inches i = new Inches(1.0);
        assertFalse(i.equals(100));
    }

    @Test
    public void testInchesEquality_SameReference() {
        Inches i = new Inches(1.0);
        assertTrue(i.equals(i));
    }
}
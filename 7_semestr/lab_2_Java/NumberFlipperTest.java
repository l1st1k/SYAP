import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class NumberFlipperTest {
    @Test
    public void testPositiveNumber() {
        assertEquals(321, NumberFlipper.flipNumber(123));
        assertEquals(2135, NumberFlipper.flipNumber(5312));
    }

    @Test
    public void testNegativeNumber() {
        assertEquals(-321, NumberFlipper.flipNumber(-123));
    }

    @Test
    public void testSingleDigitNumber() {
        assertEquals(2, NumberFlipper.flipNumber(2));
    }

    @Test
    public void testZero() {
        assertEquals(0, NumberFlipper.flipNumber(0));
    }
}

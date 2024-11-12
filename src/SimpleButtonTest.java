import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;

public class SimpleButtonTest {
    /**
     * Test if the method works when clicking inside the button.
     */
    @Test
    public void testIsClickedInside() {
        SimpleButton button = new SimpleButton(10, 10, 50, 50, Color.RED, true, 1);
        assertTrue(button.isClicked(20, 20));
    }

    /**
     * Test if the method works when clicking outside the button.
     */
    @Test
    public void testIsClickedOutside() {
        SimpleButton button = new SimpleButton(10, 10, 50, 50, Color.RED, true, 1);
        assertFalse(button.isClicked(80, 80));
    }

    /**
     * Test if the action code is returned correctly.
     */
    @Test
    public void testGetActionCode() {
        SimpleButton button = new SimpleButton(10, 10, 50, 50, Color.RED, true, 5);
        assertEquals(5, button.getActionCode());
    }
}

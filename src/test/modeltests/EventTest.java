package modeltests;

import model.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    private Event event;

    @BeforeEach
    public void runBefore() {
        event = new Event("Account is added");
    }

    @Test
    public void testEvent() {
        assertEquals("Account is added", event.getDescription());

    }

    @Test
    public void testToString() {
        assertEquals("\n" + "Account is added", event.toString());
    }

}

package module1;

import org.junit.Test;
import static org.junit.Assert.*;

public class TouristTests {

    @Test(expected = IllegalStateException.class)
    public void testNullList() {
        TouristList touristList = new TouristList();
        assertEquals(0, touristList.getSize());
        touristList.getFirst();
    }

    @Test
    public void testAddFirst() {
        TouristList touristList = new TouristList();
        touristList.addFirst("Waldo", 12345, "Prague");
        assertEquals(1, touristList.getSize());
        assertEquals("Waldo", touristList.getFirst());
    }

    @Test
    public void testFindNode() {
        TouristList touristList = new TouristList();
        touristList.addFirst("Waldo", 12345, "Prague");
        touristList.addFirst("Baldo", 124, "San Diego");
        touristList.addFirst("Crawldo", 4213, "Carmen");
        assertEquals("San Diego", touristList.findNode("Baldo"));
    }

    @Test
    public void testFindNodeMissingPerson() {
        TouristList touristList = new TouristList();
        touristList.addFirst("Waldo", 12345, "Prague");
        touristList.addFirst("Baldo", 124, "San Diego");
        touristList.addFirst("Crawldo", 4213, "Carmen");
        assertEquals("Person not found", touristList.findNode("Renaldo"));
    }
}

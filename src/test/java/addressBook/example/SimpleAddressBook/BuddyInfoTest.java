package addressBook.example.SimpleAddressBook;

import addressBook.example.SimpleAddressBook.Model.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuddyInfoTest {

    /** The bd 1. */
    private BuddyInfo bd1,bd2,bd3;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        bd1 = new BuddyInfo("Raj", "Carleton", "123");
        bd2 = new BuddyInfo("Bansal", "Ottawa", "123");
        bd3 = new BuddyInfo("John", "Toronto", "123");
    }

    /**
     * Test age.
     */
    @Test
    public void testName() {
        bd1.setName("Raj");
        assertEquals("Raj", bd1.getName());
    }

    /**
     * Test age.
     */
    @Test
    public void testAddress() {
        bd1.setName("street");
        assertEquals("street", bd1.getAddress());
    }

    /**
     * Test age.
     */
    @Test
    public void testNumber() {
        bd1.setName("123");
        assertEquals("123", bd1.getNumber());
    }
}
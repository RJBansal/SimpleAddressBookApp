package addressBook.example.SimpleAddressBook;

import addressBook.example.SimpleAddressBook.Model.AddressBook;
import addressBook.example.SimpleAddressBook.Model.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddressBookTest {

    /** The book 1. */
    private AddressBook book1;

    /** The bd 1. */
    private BuddyInfo bd1;

    /** The bd 2. */
    private BuddyInfo bd2;

    /** The bd 3. */
    private BuddyInfo bd3;

    /**
     * Sets the up.
     *
     * @throws Exception
     *             the exception
     */
    @Before
    public void setUp() throws Exception {
        book1 = new AddressBook();
        bd1 = new BuddyInfo("Raj", "Carleton", "123");
        bd2 = new BuddyInfo("Bansal", "Ottawa", "123");
        bd3 = new BuddyInfo("John", "Toronto", "123");
    }

    /**
     * Test size.
     */
    @Test
    public void testSize() {
        book1.addBuddy(bd1);
        book1.addBuddy(bd2);
        book1.addBuddy(bd3);
        assertEquals(3, book1.size());
    }

    /**
     * Test size.
     */
    @Test
    public void testRemove() {
        book1.addBuddy(bd1);
        book1.addBuddy(bd2);
        book1.addBuddy(bd3);
        book1.removeBuddy(bd1);
        assertEquals(2, book1.size());
    }
}
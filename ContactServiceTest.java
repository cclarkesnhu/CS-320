package GrandStrandSystems;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ContactServiceTest {
    private ContactService contactService;
    private Contact contact;

    @Before
    public void setUp() {
        contactService = new ContactService();
        contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
    }

    @Test
    public void testAddContact() {
        assertAll("Verify contact added",
            () -> assertEquals(1, contactService.getContacts().size()),
            () -> assertEquals(contact, contactService.getContactById("1"))
        );
    }

    @Test
    public void testDeleteContact() {
        contactService.deleteContact("1");
        assertAll("Verify contact deleted",
            () -> assertEquals(0, contactService.getContacts().size()),
            () -> assertNull(contactService.getContactById("1"))
        );
    }

    @Test
    public void testUpdateContactFields() {
        contactService.updateFirstName("1", "Jane");
        contactService.updateLastName("1", "Smith");
        contactService.updatePhone("1", "9876543210");
        contactService.updateAddress("1", "456 Elm St");

        assertAll("Verify contact updates",
            () -> assertEquals("Jane", contactService.getContactById("1").getFirstName()),
            () -> assertEquals("Smith", contactService.getContactById("1").getLastName()),
            () -> assertEquals("9876543210", contactService.getContactById("1").getPhoneNumber()),
            () -> assertEquals("456 Elm St", contactService.getContactById("1").getAddress())
        );
    }
}
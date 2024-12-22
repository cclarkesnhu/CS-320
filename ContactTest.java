package GrandStrandSystems;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContactTest {

    @Test
    public void testContactConstructorValid() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        assertAll("contact",
            () -> assertEquals("1", contact.getContactID()),
            () -> assertEquals("John", contact.getFirstName()),
            () -> assertEquals("Doe", contact.getLastName()),
            () -> assertEquals("1234567890", contact.getPhoneNumber()),
            () -> assertEquals("123 Main St", contact.getAddress())
        );
    }

    @Test
    public void testInvalidContactFields() {
        // Test invalid Contact ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });

        // Test invalid First Name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", null, "Doe", "1234567890", "123 Main St");
        });

        // Test invalid Last Name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", null, "1234567890", "123 Main St");
        });

        // Test invalid Phone Number
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "12345", "123 Main St");
        });

        // Test invalid Address
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "1234567890", null);
        });
    }
}
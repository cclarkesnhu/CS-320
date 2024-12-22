package GrandStrandSystems;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact already exists or is null");
        }
        contacts.put(contact.getContactID(), contact);
    }

    public void deleteContact(String contactID) {
        if (contactID == null || !contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID is invalid");
        }
        contacts.remove(contactID);
    }

    public void updateFirstName(String contactID, String newFirstName) {
        Contact contact = getValidatedContact(contactID);
        contact.setFirstName(newFirstName); // Validation handled in Contact class
    }

    public void updateLastName(String contactID, String newLastName) {
        Contact contact = getValidatedContact(contactID);
        contact.setLastName(newLastName); // Validation handled in Contact class
    }

    public void updatePhone(String contactID, String newNumber) {
        Contact contact = getValidatedContact(contactID);
        contact.setPhoneNumber(newNumber); // Validation handled in Contact class
    }

    public void updateAddress(String contactID, String newAddress) {
        Contact contact = getValidatedContact(contactID);
        contact.setAddress(newAddress); // Validation handled in Contact class
    }

    private Contact getValidatedContact(String contactID) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact with given ID does not exist");
        }
        return contact;
    }

    public Contact getContactById(String contactID) {
        return contacts.get(contactID);
    }

    public Map<String, Contact> getContacts() {
        return contacts;
    }
}
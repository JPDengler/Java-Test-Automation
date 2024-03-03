import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setup() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        // Add contact
        contactService.addContact(contact);
        Contact retrievedContact = contactService.getContact("1234567890");
        Assertions.assertEquals(contact, retrievedContact);
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Update contact field
        contactService.updateContact("1234567890", "firstName", "Jane");
        Contact retrievedContact = contactService.getContact("1234567890");
        Assertions.assertEquals("Jane", retrievedContact.getFirstName());
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Delete contact
        contactService.deleteContact("1234567890");
        Contact retrievedContact = contactService.getContact("1234567890");
        Assertions.assertNull(retrievedContact);
    }

    @Test
    public void testAddDuplicateContact() {
        Contact contact1 = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1234567890", "Jane", "Smith", "9876543210", "456 Oak St");

        contactService.addContact(contact1);
        // Adding duplicate contact should fail
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
    }
}
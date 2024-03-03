import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactInitialization() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        Assertions.assertEquals("12345", contact.getContactId());
        Assertions.assertEquals("John", contact.getFirstName());
        Assertions.assertEquals("Doe", contact.getLastName());
        Assertions.assertEquals("1234567890", contact.getPhone());
        Assertions.assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testContactSetters() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        contact.setFirstName("Jane");
        Assertions.assertEquals("Jane", contact.getFirstName());

        contact.setLastName("Smith");
        Assertions.assertEquals("Smith", contact.getLastName());

        contact.setPhone("9876543210");
        Assertions.assertEquals("9876543210", contact.getPhone());

        contact.setAddress("456 Oak St");
        Assertions.assertEquals("456 Oak St", contact.getAddress());
    }

    @Test
    public void testContactEqualsAndHashCode() {
        Contact contact1 = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        Assertions.assertEquals(contact1, contact2, "Contacts are not equal");
        Assertions.assertEquals(contact1.hashCode(), contact2.hashCode(), "Hash codes are not equal");
    }
}
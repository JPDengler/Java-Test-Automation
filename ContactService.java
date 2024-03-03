public class ContactService {
    private Map<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        String contactId = contact.getContactId();
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }

        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with ID " + contactId + " already exists");
        }

        validateContactFields(contact);

        contacts.put(contactId, contact);
    }

    public void deleteContact(String contactId) {
        contacts.remove(contactId);
    }

    public void updateContact(String contactId, String field, String value) {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
            switch (field) {
                case "firstName":
                    if (value != null && !value.isEmpty()) {
                        contact.setFirstName(value);
                    } else {
                        throw new IllegalArgumentException("First name cannot be null or empty");
                    }
                    break;
                case "lastName":
                    if (value != null && !value.isEmpty()) {
                        contact.setLastName(value);
                    } else {
                        throw new IllegalArgumentException("Last name cannot be null or empty");
                    }
                    break;
                case "phone":
                    if (value != null && value.length() == 10) {
                        contact.setPhone(value);
                    } else {
                        throw new IllegalArgumentException("Invalid phone number");
                    }
                    break;
                case "address":
                    if (value != null && !value.isEmpty()) {
                        contact.setAddress(value);
                    } else {
                        throw new IllegalArgumentException("Address cannot be null or empty");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field: " + field);
            }
        }
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    private void validateContactFields(Contact contact) {
        if (contact.getFirstName() == null || contact.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        if (contact.getLastName() == null || contact.getLastName().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        if (contact.getPhone() == null || contact.getPhone().length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        if (contact.getAddress() == null || contact.getAddress().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
    }
}
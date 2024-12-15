import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }
    public List<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        // Check for duplicate contact before adding
        boolean exists = contacts.stream()
                .anyMatch(c -> c.equals(contact));  // Use the overridden equals method to check for duplicates

        if (exists) {
            System.out.println("This contact already exists in the Address Book.");
        } else {
            contacts.add(contact);
            System.out.println("Contact added successfully!");
        }
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts in the Address Book.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    // Edit an existing contact
    public boolean editContact(String firstName, String lastName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Editing contact: " + contact);
                System.out.println("Enter new Address: ");
                contact.setAddress(scanner.nextLine());
                System.out.println("Enter new City: ");
                contact.setCity(scanner.nextLine());
                System.out.println("Enter new State: ");
                contact.setState(scanner.nextLine());
                System.out.println("Enter new Zip: ");
                contact.setZip(scanner.nextLine());
                System.out.println("Enter new Phone Number: ");
                contact.setPhoneNumber(scanner.nextLine());
                System.out.println("Enter new Email: ");
                contact.setEmail(scanner.nextLine());

                return true;
            }
        }
        return false;  // Contact not found
    }

    // Delete a contact
    public boolean deleteContact(String firstName, String lastName) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                contacts.remove(i);
                return true;
            }
        }
        return false;  // Contact not found
    }
}
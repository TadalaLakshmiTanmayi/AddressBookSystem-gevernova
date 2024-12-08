// AddressBook.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
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
    // Add method in AddressBook.java to edit a contact
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

}

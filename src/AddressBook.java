import java.util.*;

public class AddressBook {
    private List<Contact> contacts;
    private Map<String, List<Contact>> cityDictionary;
    private Map<String, List<Contact>> stateDictionary;

    public AddressBook() {
        contacts = new ArrayList<>();
        cityDictionary = new HashMap<>();
        stateDictionary = new HashMap<>();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    // Add a contact and update city and state dictionaries
    public void addContact(Contact contact) {
        // Add the contact to the list
        contacts.add(contact);

        // Update city dictionary
        cityDictionary.computeIfAbsent(contact.getCity(), k -> new ArrayList<>()).add(contact);

        // Update state dictionary
        stateDictionary.computeIfAbsent(contact.getState(), k -> new ArrayList<>()).add(contact);

        System.out.println("Contact added successfully!");
    }

    // Display all contacts
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts in the Address Book.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    // Search for contacts by city
    public List<Contact> searchByCity(String city) {
        return cityDictionary.getOrDefault(city, Collections.emptyList());
    }

    // Search for contacts by state
    public List<Contact> searchByState(String state) {
        return stateDictionary.getOrDefault(state, Collections.emptyList());
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

                // Update the dictionaries to remove the contact from city and state mappings
                cityDictionary.getOrDefault(contact.getCity(), new ArrayList<>()).remove(contact);
                stateDictionary.getOrDefault(contact.getState(), new ArrayList<>()).remove(contact);

                return true;
            }
        }
        return false;  // Contact not found
    }
}

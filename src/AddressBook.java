import java.util.*;
import java.util.stream.Collectors;

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
        contacts.add(contact);
        cityDictionary.computeIfAbsent(contact.getCity(), k -> new ArrayList<>()).add(contact);
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

    // Search for contacts by city and return a count
    public void searchByCityWithCount(String city) {
        long count = contacts.stream()
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .count();

        if (count > 0) {
            System.out.println("Number of contacts in city '" + city + "': " + count);
            contacts.stream()
                    .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                    .forEach(System.out::println);
        } else {
            System.out.println("No contacts found in city: " + city);
        }
    }

    // Search for contacts by state and return a count
    public void searchByStateWithCount(String state) {
        long count = contacts.stream()
                .filter(contact -> contact.getState().equalsIgnoreCase(state))
                .count();

        if (count > 0) {
            System.out.println("Number of contacts in state '" + state + "': " + count);
            contacts.stream()
                    .filter(contact -> contact.getState().equalsIgnoreCase(state))
                    .forEach(System.out::println);
        } else {
            System.out.println("No contacts found in state: " + state);
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

                // Update the dictionaries to remove the contact from city and state mappings
                cityDictionary.getOrDefault(contact.getCity(), new ArrayList<>()).remove(contact);
                stateDictionary.getOrDefault(contact.getState(), new ArrayList<>()).remove(contact);

                return true;
            }
        }
        return false;  // Contact not found
    }
    // Sort contacts by first and last name alphabetically
    public void sortContactsByName() {
        Collections.sort(contacts, Comparator.comparing(Contact::getFirstName)
                .thenComparing(Contact::getLastName));
        System.out.println("Contacts sorted by name.");
    }
    // Sort contacts by city
    public void sortContactsByCity() {
        Collections.sort(contacts, Comparator.comparing(Contact::getCity));
        System.out.println("Contacts sorted by City.");
    }

    // Sort contacts by state
    public void sortContactsByState() {
        Collections.sort(contacts, Comparator.comparing(Contact::getState));
        System.out.println("Contacts sorted by State.");
    }

    // Sort contacts by zip
    public void sortContactsByZip() {
        Collections.sort(contacts, Comparator.comparing(Contact::getZip));
        System.out.println("Contacts sorted by Zip.");
    }
}

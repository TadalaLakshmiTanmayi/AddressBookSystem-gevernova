import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        Scanner scanner = new Scanner(System.in);
        Map<String, AddressBook> addressBooks = new HashMap<>();
        AddressBook currentAddressBook = null;

        // Main program loop
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create a new Address Book");
            System.out.println("2. Choose an existing Address Book");
            System.out.println("3. Search by City or State");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    // Create a new Address Book
                    System.out.print("Enter the name for the new Address Book: ");
                    String newBookName = scanner.nextLine();

                    if (addressBooks.containsKey(newBookName)) {
                        System.out.println("Address Book with this name already exists.");
                    } else {
                        AddressBook newAddressBook = new AddressBook();
                        addressBooks.put(newBookName, newAddressBook);
                        System.out.println("New Address Book created with the name: " + newBookName);
                    }
                    break;
                case 2:
                    // Choose an existing Address Book
                    System.out.print("Enter the name of the Address Book you want to select: ");
                    String bookName = scanner.nextLine();

                    if (addressBooks.containsKey(bookName)) {
                        currentAddressBook = addressBooks.get(bookName);
                        manageAddressBook(scanner, currentAddressBook); // Manage the selected address book
                    } else {
                        System.out.println("Address Book not found.");
                    }
                    break;
                case 3:
                    // Search by City or State
                    System.out.print("Enter '1' to search by City or '2' to search by State: ");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    if (searchChoice == 1) {
                        System.out.print("Enter the City to search: ");
                        String city = scanner.nextLine();
                        searchByCity(addressBooks, city);
                    } else if (searchChoice == 2) {
                        System.out.print("Enter the State to search: ");
                        String state = scanner.nextLine();
                        searchByState(addressBooks, state);
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 4:
                    // Exit the program
                    System.out.println("Thank you for using the Address Book program.");
                    scanner.close();
                    return; // Exit the program immediately
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    // Helper method to manage a selected AddressBook
    private static void manageAddressBook(Scanner scanner, AddressBook addressBook) {
        // Main loop for managing address book
        while (true) {
            System.out.println("\nChoose an option for the current Address Book:");
            System.out.println("1. Add a new contact");
            System.out.println("2. Display all contacts");
            System.out.println("3. Edit an existing contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Sort contacts by name");
            System.out.println("6. Go back to main menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Add new contact
                    boolean addMore = true;
                    while (addMore) {
                        System.out.println("Enter First Name: ");
                        String firstName = scanner.nextLine();
                        System.out.println("Enter Last Name: ");
                        String lastName = scanner.nextLine();
                        System.out.println("Enter Address: ");
                        String address = scanner.nextLine();
                        System.out.println("Enter City: ");
                        String city = scanner.nextLine();
                        System.out.println("Enter State: ");
                        String state = scanner.nextLine();
                        System.out.println("Enter Zip: ");
                        String zip = scanner.nextLine();
                        System.out.println("Enter Phone Number: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.println("Enter Email: ");
                        String email = scanner.nextLine();

                        // Create and add the new contact
                        Contact newContact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
                        addressBook.addContact(newContact);

                        // Ask if the user wants to add another contact
                        System.out.println("Do you want to add another contact? (y/n)");
                        String addMoreChoice = scanner.nextLine();
                        addMore = addMoreChoice.equalsIgnoreCase("y");
                    }
                    break;
                case 2:
                    // Display all contacts
                    addressBook.displayContacts();
                    break;
                case 3:
                    // Edit a contact
                    System.out.println("Enter First Name and Last Name of the contact to edit:");
                    String firstName = scanner.nextLine();
                    String lastName = scanner.nextLine();
                    if (!addressBook.editContact(firstName, lastName)) {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    // Delete a contact
                    System.out.println("Enter First Name and Last Name of the contact to delete:");
                    firstName = scanner.nextLine();
                    lastName = scanner.nextLine();
                    if (!addressBook.deleteContact(firstName, lastName)) {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 5:
                    // Sort contacts by name
                    addressBook.sortContactsByName();
                    break;
                case 6:
                    // Go back to main menu
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    // Helper method for searching by city
    private static void searchByCity(Map<String, AddressBook> addressBooks, String city) {
        for (Map.Entry<String, AddressBook> entry : addressBooks.entrySet()) {
            System.out.println("\nSearching in Address Book: " + entry.getKey());
            entry.getValue().searchByCityWithCount(city);
        }
    }

    // Helper method for searching by state
    private static void searchByState(Map<String, AddressBook> addressBooks, String state) {
        for (Map.Entry<String, AddressBook> entry : addressBooks.entrySet()) {
            System.out.println("\nSearching in Address Book: " + entry.getKey());
            entry.getValue().searchByStateWithCount(state);
        }
    }
}

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        Scanner scanner = new Scanner(System.in);
        Map<String, AddressBook> addressBooks = new HashMap<>();
        AddressBook currentAddressBook = null;

        int i = 1;

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create a new Address Book");
            System.out.println("2. Choose an existing Address Book");
            System.out.println("3. Exit");
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
                        manageAddressBook(scanner, currentAddressBook);
                    } else {
                        System.out.println("Address Book not found.");
                    }
                    break;
                case 3:
                    // Exit
                    System.out.println("Thank you for using the Address Book program.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (i != 3);

        scanner.close();
    }

    // Helper method to manage a selected AddressBook
    private static void manageAddressBook(Scanner scanner, AddressBook addressBook) {
        int i = 1;

        do {
            System.out.println("\nChoose an option for the current Address Book:");
            System.out.println("1. Add a new contact");
            System.out.println("2. Display all contacts");
            System.out.println("3. Edit an existing contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Go back to main menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

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
                        System.out.println("Contact added successfully!");

                        // Ask if the user wants to add another contact
                        System.out.println("Do you want to add another contact? (yes/no): ");
                        String response = scanner.nextLine().toLowerCase();
                        if (response.equals("no")) {
                            addMore = false;
                        }
                    }
                    break;
                case 2:
                    // Display all contacts in the address book
                    System.out.println("Displaying all contacts:");
                    addressBook.displayContacts();
                    break;
                case 3:
                    // Edit an existing contact
                    System.out.println("Enter the name of the contact to edit (FirstName LastName): ");
                    String[] nameToEdit = scanner.nextLine().split(" ");
                    String firstNameToEdit = nameToEdit[0];
                    String lastNameToEdit = nameToEdit[1];

                    boolean edited = addressBook.editContact(firstNameToEdit, lastNameToEdit);
                    if (edited) {
                        System.out.println("Contact updated successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    // Delete a contact
                    System.out.println("Enter the name of the contact to delete (FirstName LastName): ");
                    String[] nameToDelete = scanner.nextLine().split(" ");
                    String firstNameToDelete = nameToDelete[0];
                    String lastNameToDelete = nameToDelete[1];

                    boolean deleted = addressBook.deleteContact(firstNameToDelete, lastNameToDelete);
                    if (deleted) {
                        System.out.println("Contact deleted successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 5:
                    // Go back to the main menu
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }

            System.out.println("Enter 0 to exit or any other number to continue:");
            i = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

        } while (i != 0);
    }
}

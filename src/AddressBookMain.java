import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        int i = 1;

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a new contact");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    // Add new contact
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
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }

            System.out.println("Enter 0 to exit or any other number to continue:");
            i = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character again after reading integer input

        } while (i != 0);

        System.out.println("Thank You");
        scanner.close();
    }
}

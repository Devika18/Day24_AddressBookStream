import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {
    private final List<Contacts> addressBook = new ArrayList<>();

    private static final Scanner sc = new Scanner(System.in);

    private void addPerson() {
        Contacts person = new Contacts();
        System.out.println("Enter First Name");
        String firstName = sc.nextLine();
        System.out.println("Enter Last Name");
        String lastName = sc.nextLine();
        System.out.println("Enter Address");
        String address = sc.nextLine();
        System.out.println("Enter City");
        String city = sc.nextLine();
        System.out.println("Enter State");
        String state = sc.nextLine();
        System.out.println("Enter Zip code");
        int zipcode = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Phone Number");
        long phoneNumber = Long.parseLong(sc.nextLine());

        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAddress(address);
        person.setCity(city);
        person.setState(state);
        person.setZipCode(zipcode);
        person.setPhoneNumber(phoneNumber);

        addressBook.add(person);
    }

    private void editPerson() {
        System.out.println("Enter the Name");
        String personName = sc.nextLine();
        Contacts personDetails = null;
        for (Contacts details : addressBook) {
            if (personName.equals(details.getFirstName()) || personName.equals(details.getLastName())) {
                personDetails = details;
                break;
            }
        }
        if (personDetails != null) {
            System.out.println("Enter Address");
            String address = sc.nextLine();
            System.out.println("Enter City");
            String city = sc.nextLine();
            System.out.println("Enter State");
            String state = sc.nextLine();
            System.out.println("Enter Zip code");
            int zipcode = Integer.parseInt(sc.nextLine());
            System.out.println("Enter Phone Number");
            long phoneNumber = Long.parseLong(sc.nextLine());
            personDetails.setAddress(address);
            personDetails.setCity(city);
            personDetails.setState(state);
            personDetails.setZipCode(zipcode);
            personDetails.setPhoneNumber(phoneNumber);
        } else {
            System.out.println("No contacts details found");
        }
    }

    private void showAddressBook() {
        for (Contacts personDetails : addressBook) {
            System.out.println(personDetails);
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");
        boolean isExit = false;
        AddressBookMain addressBookMain = new AddressBookMain();

        while (!isExit) {
            System.out.println("""
                     Select below
                    1. Add Person details
                    2. show Address book
                    3. Exit""");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> addressBookMain.addPerson();
                case 2 -> addressBookMain.editPerson();
                case 3 -> addressBookMain.showAddressBook();
                case 4 -> isExit = true;
                default -> System.out.println("Please enter valid details");
            }
        }
    }
}

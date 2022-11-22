import java.util.*;

public class AddressBookMain {
    private List<Contacts> addressBook;

    //Map is used to store data in key and value format.
    //Used create multiple address books
    private final Map<String, List> addressBooks = new HashMap<String, List>();

    private static final Scanner sc = new Scanner(System.in);

    private void addPerson() {
        System.out.println("Please select the book");
        String bookName = sc.nextLine();
        addressBook = getAddressBook(bookName);
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
        System.out.println("Please select the book");
        String bookName = sc.nextLine();
        addressBook = getAddressBook(bookName);
        System.out.println("Enter the person name");
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
            System.out.println("No contacts details found" + personName);
        }
    }

    private void deletePerson() {
        System.out.println("Please select the book");
        String bookName = sc.nextLine();
        addressBook = getAddressBook(bookName);
        System.out.println("Enter the person name");
        String personName = sc.nextLine();
        for (int i = 0; i < addressBook.size(); i++) {
            if (personName.equals(addressBook.get(i).getFirstName()) || personName.equals(addressBook.get(i).getLastName())) {
                addressBook.remove(i);
                System.out.println("Deleting contact......");
            } else {
                System.out.println("No contact found");
            }
        }
    }

    private void showAddressBook() {
        System.out.println("Please select the book");
        String bookName = sc.nextLine();
        addressBook = getAddressBook(bookName);
        for (Contacts personDetails : addressBook) {
            System.out.println(personDetails);
        }
    }

    private List<Contacts> getAddressBook(String addressBookName) {
        addressBook = addressBooks.get(addressBookName);
        return addressBook;
    }

    private void addAddressBooks() {
        System.out.println("Enter the book name");
        String addressBookName = sc.nextLine();
        addressBook = new ArrayList<Contacts>();
        addressBooks.put(addressBookName, addressBook);
        showAddressBooks();
    }

    private void showAddressBooks() {
        for (Map.Entry<String, List> entry : addressBooks.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + " " + value);
        }
    }


    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");
        boolean isExit = false;
        AddressBookMain addressBookMain = new AddressBookMain();

        while (!isExit) {
            System.out.println("""
                     Select option
                    1. Add new Address book
                    2. Add new person details
                    3. Edit person details
                    4. Delete Person
                    5. show Address book
                    6. show total Address books
                    7. Exit""");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> addressBookMain.addAddressBooks();
                case 2 -> addressBookMain.addPerson();
                case 3 -> addressBookMain.editPerson();
                case 4 -> addressBookMain.deletePerson();
                case 5 -> addressBookMain.showAddressBook();
                case 6 -> addressBookMain.showAddressBooks();
                case 7 -> isExit = true;
                default -> System.out.println("Please enter valid details");
            }
        }
    }
}

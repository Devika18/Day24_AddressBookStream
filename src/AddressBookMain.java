import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {
    private List<Contacts> addressBook;

    //Map is used to store data in key and value format.
    //Used create multiple address books
    private Map<String, List<Contacts>> addressBooks = new HashMap<String, List<Contacts>>();

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

    //Searching person details are duplicate or not
    public void searchPerson() {
        System.out.println("Please select the book");
        String bookName = sc.nextLine();
        addressBook = getAddressBook(bookName);
        System.out.println("Enter the First name");
        String firstName = sc.nextLine();
        System.out.println("Enter the Last name");
        String lastName = sc.nextLine();

        if (isPersonAdded(addressBook, firstName, lastName)) {
            System.out.println("duplicate Entry");
        } else {
            System.out.println("No Entry found so adding person");
            addPerson();
        }
    }

    // checking person by first name and last name.
    public boolean isPersonAdded(List<Contacts> personList, String firstName, String lastName) {
        return personList.stream().anyMatch(item -> item.equals(firstName) && item.equals(lastName));
    }


    //searching person from all address books by using city or state
    private void searchPersonInMultipleBook() {
        addressBook = getAddressBook(null);
        System.out.println("Enter the city or state name");
        String name = sc.nextLine();

        if (SearchPersonInMultipleBook(addressBooks, name).size() > 0) {
            printMap(SearchPersonInMultipleBook(addressBooks, name));
        } else {
            System.out.println("No Details Found");
        }
    }

    public Map<String, List<Contacts>> SearchPersonInMultipleBook(Map<String, List<Contacts>> addressBooks, String input) {
        HashMap<String, List<Contacts>> allDetails = new HashMap<>();
        List<Contacts> allPerson;
        for (Map.Entry<String, List<Contacts>> list : addressBooks.entrySet()) {
            allPerson = list.getValue().stream()
                    .filter(i -> i.getCity().equals(input) || i.getState().equals(input))
                    .collect(Collectors.toList());
            allDetails.put(list.getKey(), allPerson);

        }
        return allDetails;
    }


    //Provided person details
    {
        addressBooks = new HashMap<>();
        addressBook = new ArrayList<>();
        List<Contacts> addressBook1 = new ArrayList<>();
        addressBook.add(new Contacts("Siddharth", "Karpe", "Swargate", "Pune", "Maharashtra", 898977, 1122334455L));
        addressBook.add(new Contacts("Suraj", "Shinde", "Powai", "Mumbai", "Maharashtra", 114466, 9988776655L));
        addressBook.add(new Contacts("Devika", "Karpe", "Pune", "Pune", "Maharashtra", 123456, 1234567891L));
        addressBook1.add(new Contacts("Asmita", "Landge", "Pune", "Pune", "Maharashtra", 567123, 9078564321L));
        addressBook1.add(new Contacts("Juee", "Shinde", "Thane", "Mumbai", "Maharashtra", 369258, 9321356488L));
        addressBook1.add(new Contacts("Sayali", "Wagh", "Hadapsar", "Pune", "Maharashtra", 987654, 7741258926L));
        addressBooks.put("A", addressBook);
        addressBooks.put("B", addressBook1);
    }

    public void printMap(Map<String, List<Contacts>> map) {
        for (Map.Entry<String, List<Contacts>> list : map.entrySet()) {
            System.out.println("address book : " + list.getKey());
            for (Contacts details : list.getValue()) {

                System.out.print("First name : " + details.getFirstName() + " , ");
                System.out.print("Last name : " + details.getLastName() + " , ");
                System.out.print("Address : " + details.getAddress() + " , ");
                System.out.print("City : " + details.getCity() + " , ");
                System.out.print("State : " + details.getState() + " , ");
                System.out.print("Zipcode : " + details.getZipCode() + " , ");
                System.out.print("Phone Number : " + details.getPhoneNumber());
                System.out.println();
            }
            System.out.println("---------------------------------------------");
        }
    }

    public void showAddressBooks() {
        printMap(addressBooks);
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
        printMap(addressBooks);
    }


    public static void main(String[] args) {
        System.out.println("Welcome to AddressBook Stream Program");
        boolean isExit = false;
        AddressBookMain addressBookMain = new AddressBookMain();

        while (!isExit) {
            System.out.println("""
                     Select option
                    Select option
                    1. Add new Address book
                    2. Add new person details
                    3. Edit person details
                    4. Delete Person
                    5. show Address book
                    6. show total Address books
                    7. Search person for duplicate entry
                    8. search Person in a City or State from all AddressBook
                    9. Exit""");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> addressBookMain.addAddressBooks();
                case 2 -> addressBookMain.addPerson();
                case 3 -> addressBookMain.editPerson();
                case 4 -> addressBookMain.deletePerson();
                case 5 -> addressBookMain.showAddressBook();
                case 6 -> addressBookMain.showAddressBooks();
                case 7 -> addressBookMain.searchPerson();
                case 8 -> addressBookMain.searchPersonInMultipleBook();
                case 9 -> isExit = true;
                default -> System.out.println("Please enter valid details");
            }
        }
    }
}

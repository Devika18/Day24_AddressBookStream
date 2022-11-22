public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");
        Contacts personDetails=new Contacts();
        personDetails.setFirstName("Vivek");
        personDetails.setLastName("Gujale");
        personDetails.setAddress("Kalamboli");
        personDetails.setCity("Panvel");
        personDetails.setState("Maharashtra");
        personDetails.setZipCode(456123);
        personDetails.setPhoneNumber(1234567890L);
        System.out.println(personDetails);
    }
}

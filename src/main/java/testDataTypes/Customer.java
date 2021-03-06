package testDataTypes;

public class Customer {
    public String firstName;
    public String lastName;
    public String password;
    public String emailAddress;
    public String company;
    public Address address;
    public PhoneNumber phoneNumber;
    public String website;



    public class Address {
        public String streetAddress;
        public String suiteAddress;
        public String city;
        public String state;
        public String postCode;
        public String country;

    }



    public class PhoneNumber {
        public String home;
        public String mob;

    }
}

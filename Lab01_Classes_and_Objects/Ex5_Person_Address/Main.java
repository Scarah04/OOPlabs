// Lab 1 - Exercise 5 (Challenge): Person has an Address; chained dot and null handling
class Address {
    String city;
    Address(String city) { this.city = city; }
}

class Person {
    String name;
    Address address;
    Person(String name, Address address) { this.name = name; this.address = address; }
}

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Tendai", new Address("Harare"));
        System.out.println(p1.name + " lives in " + p1.address.city);   // chained dot

        Person p2 = new Person("Rudo", null);
        try {
            System.out.println(p2.address.city);   // address is null
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + p2.name + " has no address (null).");
        }
        // Safe version: check for null first
        String city = (p2.address != null) ? p2.address.city : "unknown";
        System.out.println("Safe lookup for " + p2.name + ": " + city);
    }
}

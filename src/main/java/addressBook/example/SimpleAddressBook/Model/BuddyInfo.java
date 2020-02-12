package addressBook.example.SimpleAddressBook.Model;

import javax.persistence.*;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;
    private String number;

    private AddressBook book;

    public BuddyInfo() {}

    public BuddyInfo(String name) {
        this.name = name;
    }

    public BuddyInfo(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.number = phoneNumber;
    }

    public BuddyInfo(BuddyInfo buddy) {
        this.setAddress(buddy.getAddress());
        this.setName(buddy.getName());
        this.setNumber(buddy.getNumber());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String Welcome() {
        return"Welcome "+ getName();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String phoneNumber) {
        this.number = phoneNumber;
    }

    public long geId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String toString() {
        return name + " - Address: " + address + " Phone Number: " + number;
    }
}

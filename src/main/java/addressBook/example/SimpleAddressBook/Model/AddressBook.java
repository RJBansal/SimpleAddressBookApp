package addressBook.example.SimpleAddressBook.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany (cascade = CascadeType.PERSIST)
    public List<BuddyInfo> buddyInfo;

    public AddressBook() {
        buddyInfo = new ArrayList<BuddyInfo>();
    }

    public AddressBook(String name) {
        this();
        this.name = name;
    }

    //add a buddy
    public void addBuddy(BuddyInfo buddy) {

        buddyInfo.add(buddy);
    }

    public void addBuddy(String name, String address, String number) {

        addBuddy(new BuddyInfo(name, address, number));

    }


    public void removeBuddy(BuddyInfo buddy) {

        for (int i = 0; i < buddyInfo.size(); i++) {
            if (buddyInfo.get(i).equals(buddy)) {
                buddyInfo.remove(i);
            }
        }
    }

    public boolean removeBuddy(String name) {

        for (int i = 0; i < buddyInfo.size(); i++) {
            if (buddyInfo.get(i).getName().equals(name)) {
                buddyInfo.remove(i);
                return true;
            }
        }
        return false;
    }

    public int size() {
        return buddyInfo.size();
    }

    public void clear() {
        buddyInfo.clear();
        System.out.println("Cleared all buddies!");
    }

    public Long geId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<BuddyInfo> getBuddyInfo() {
        return buddyInfo;
    }

    public void setBuddyInfo(List<BuddyInfo> buddies) {
        this.buddyInfo = buddies;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < buddyInfo.size(); i++) {
            output += buddyInfo.get(i).toString() + "\n";
        }
        return output;
    }
}
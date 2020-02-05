package addressBook.example.SimpleAddressBook.JPA;

import addressBook.example.SimpleAddressBook.Model.BuddyInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface BuddyRepository extends CrudRepository<BuddyInfo, Long> {

    BuddyInfo findByName(String name);
    BuddyInfo findByNumber(String number);
    BuddyInfo findByAddress(String address);

    BuddyInfo findById(long id);
}
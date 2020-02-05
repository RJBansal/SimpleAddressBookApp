package addressBook.example.SimpleAddressBook.JPA;

import addressBook.example.SimpleAddressBook.Model.AddressBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "addressBook", path = "addressBookAPI")
public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {

    AddressBook findByName(String name);

    AddressBook findById(long id);
}
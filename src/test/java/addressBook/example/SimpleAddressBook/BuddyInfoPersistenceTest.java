package addressBook.example.SimpleAddressBook;

import addressBook.example.SimpleAddressBook.Model.AddressBook;
import addressBook.example.SimpleAddressBook.Model.BuddyInfo;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BuddyInfoPersistenceTest {

    @Test
    public void test() {

        BuddyInfo buddyInfo = new BuddyInfo();
        buddyInfo.setName("Rajat");
        buddyInfo.setNumber("123");

        BuddyInfo buddyInfo2 = new BuddyInfo();
        buddyInfo2.setName("Bansal");
        buddyInfo2.setNumber("1234");

        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddyInfo);
        addressBook.addBuddy(buddyInfo2);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PresistenceAddress");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(buddyInfo);
        entityManager.persist(buddyInfo2);
        entityManager.persist(addressBook);
        transaction.commit();

        Query q = entityManager.createQuery("select buddyinfo FROM BuddyInfo buddyinfo");
        Query q2 = entityManager.createQuery("select addressBook FROM AddressBook addressBook");

        List<BuddyInfo> buddies = q.getResultList();
        List<AddressBook> books = q2.getResultList();

        for (BuddyInfo buddy : buddies) {
            System.out.println(buddy);
        }

        for (AddressBook book : books) {
            System.out.println("AddressBook");
            System.out.println(book);
        }
        assertEquals(books.get(0), addressBook);
        entityManager.close();
        emf.close();
    }

}

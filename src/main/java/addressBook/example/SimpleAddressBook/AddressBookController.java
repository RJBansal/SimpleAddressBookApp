package addressBook.example.SimpleAddressBook;

import addressBook.example.SimpleAddressBook.JPA.AddressBookRepository;
import addressBook.example.SimpleAddressBook.JPA.BuddyRepository;
import addressBook.example.SimpleAddressBook.Model.AddressBook;
import addressBook.example.SimpleAddressBook.Model.BuddyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AddressBookController {

    private AddressBook model;
    private AddressBookRepository addressBookRepository;
    private BuddyRepository buddyRepository;

    @Autowired
    public AddressBookController (AddressBookRepository addressBookRepository, BuddyRepository buddyRepository) {

        this.addressBookRepository = addressBookRepository;
        this.buddyRepository = buddyRepository;
    }

    @GetMapping("/")
    public String landingPage(Model model) {
        model.addAttribute("book", new AddressBook());
        model.addAttribute("Buddy", new BuddyInfo());
        return "home";
    }

    @PostMapping("/display")
    public String createAddressBook(@RequestParam("name") String name, Model model) {

        AddressBook ab = new AddressBook(name);
        model.addAttribute("book", ab);
        addressBookRepository.save(ab);
        return displayBook(name, model);
    }

    @GetMapping("/display")
    public String displayBook(@RequestParam("name") String name, Model model) {

        AddressBook ab = addressBookRepository.findByName(name);
        model.addAttribute("book", ab);
        model.addAttribute("Buddy", new BuddyInfo());
        return "display";
    }

    @PostMapping("/{name}/add")
    public String addBuddy(@RequestParam(name="name")String name, @RequestParam(name="address")String address, @RequestParam(name="phonenumber")String phonenumber, @RequestParam(name="book")String book, Model response) {

        model = addressBookRepository.findByName(book);
        if (model == null) {
            return "error";
        }
        else {
            model.addBuddy(name,address,phonenumber);
            response.addAttribute("buddy",model);
            addressBookRepository.save(model);
            List<BuddyInfo> result2 = new ArrayList<BuddyInfo>();
            (buddyRepository.findAll()).forEach(result2::add);
            response.addAttribute("b_list", result2);
            return "getBuddy";
        }
    }

    @DeleteMapping("/{name}/delete")
    public String removeBuddy(@PathVariable String addressBookName, @RequestParam("buddyName") String buddyName, Model model) {

        AddressBook ab = (AddressBook) addressBookRepository.findByName(addressBookName);
        ab.removeBuddy(buddyName);
        addressBookRepository.save(ab);
        return displayBook(addressBookName, model);
    }
}

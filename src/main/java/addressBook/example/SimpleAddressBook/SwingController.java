package addressBook.example.SimpleAddressBook;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwingController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
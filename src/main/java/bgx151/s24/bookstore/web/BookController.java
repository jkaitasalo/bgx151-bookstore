package bgx151.s24.bookstore.web;

import bgx151.s24.bookstore.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @GetMapping("/index")
    public String index(Model model) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("1984", "George Orwell", 1949, "1234567890", 9.99));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "0987654321", 7.99));

        model.addAttribute("books", books);
        return "index";
    }
}

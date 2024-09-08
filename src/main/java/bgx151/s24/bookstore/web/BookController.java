package bgx151.s24.bookstore.web;

import bgx151.s24.bookstore.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @GetMapping("/booklist")
    public String index(Model model) {
        List<Book> books = new ArrayList<>();

        model.addAttribute("books", books);
        return "booklist";
    }
}

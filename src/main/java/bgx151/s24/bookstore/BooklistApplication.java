package bgx151.s24.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bgx151.s24.bookstore.domain.Book;
import bgx151.s24.bookstore.domain.BookRepository;

@SpringBootApplication
public class BooklistApplication {

	private static final Logger log = LoggerFactory.getLogger(BooklistApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BooklistApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("saving some books");
			repository.save(new Book("Ernest Hemingway", "A Farewell to Arms", 1929, "1232323-21"));
			repository.save(new Book("George Orwell", "Animal Farm", 1945, "2212343-5"));

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}

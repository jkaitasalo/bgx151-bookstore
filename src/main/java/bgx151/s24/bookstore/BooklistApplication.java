package bgx151.s24.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bgx151.s24.bookstore.domain.Category;
import bgx151.s24.bookstore.domain.CategoryRepository;
import bgx151.s24.bookstore.domain.Book;
import bgx151.s24.bookstore.domain.BookRepository;

@SpringBootApplication
public class BooklistApplication {

	private static final Logger log = LoggerFactory.getLogger(BooklistApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BooklistApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("saving books");

			Category category1 = new Category("Scifi");
			Category category2 = new Category("Fantasy");
			Category category3 = new Category("Science");

			crepository.save(category1);
			crepository.save(category2);
			crepository.save(category3);

			brepository.save(new Book("Ernest Hemingway", "A Farewell to Arms", 1929, "1232323-21", category1));
			brepository.save(new Book("George Orwell", "Animal Farm", 1945, "2212343-5", category2));

			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}

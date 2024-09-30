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

			crepository.save(new Category("Scifi"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Science"));

			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}

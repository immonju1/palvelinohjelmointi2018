package fi.hh.course;

/* GIT testausta */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.course.domain.Book;
import fi.hh.course.domain.BookRepository;
import fi.hh.course.domain.Category;
import fi.hh.course.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Business"));
			crepository.save(new Category("Law"));
			
			// Book(String title, String author, int year, String isbn, Double price, Category category)
			brepository.save(new Book("Eka kirja", "Johnson John", 1968, "123-23DF-234-FG", 34.34, crepository.findByName("Law").get(0)));
			brepository.save(new Book("Toka kirja", "Jokunen Jaska", 2000, "123-23DF-234-FG", 34.34, crepository.findByName("Horror").get(0)));	
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}







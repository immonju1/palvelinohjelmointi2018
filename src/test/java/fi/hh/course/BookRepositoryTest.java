package fi.hh.course;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.course.domain.Book;
import fi.hh.course.domain.BookRepository;
import fi.hh.course.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
    private BookRepository repository;
	
    @Test
    public void findBytitleShouldReturnBook() {
        List<Book> books = repository.findByTitle("Eka kirja");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Johnson John");
    }
	
    @Test
    public void createNewBook() {
    	Book book = new Book("Mielensä pahoittaja", "Johnson John", 2013, "123-23DF-234-FG", 34.34, new Category("Horror"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    } 
    
}

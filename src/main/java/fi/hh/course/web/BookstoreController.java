package fi.hh.course.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import fi.hh.course.BookstoreApplication;
import fi.hh.course.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import fi.hh.course.domain.BookRepository;
import fi.hh.course.domain.Category;
import fi.hh.course.domain.CategoryRepository;

import java.lang.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class BookstoreController {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	@Autowired 
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
    @RequestMapping(value="/booklist")
    public String studentList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    
    @RequestMapping(value = "/add") 
    public String addStudent(Model model){ 
    	model.addAttribute("book", new Book()); 
    	model.addAttribute("categories", crepository.findAll());
    	return "addbook"; 
    }
    
    @RequestMapping(value = "/edit/{id}") 
    public String addStudent(@PathVariable("id") Long bookId, Model model){
    	model.addAttribute("book", repository.findById(bookId)); 
    	model.addAttribute("categories", crepository.findAll()); 
    	return "editbook";
    }
       
    @RequestMapping(value = "/save", method = RequestMethod.POST) 
    public String save(@Valid Book book, BindingResult bindingResult, Model model){ 
    	 if (bindingResult.hasErrors()) {
    		log.info("VIRHE");
    		model.addAttribute("categories", crepository.findAll());
    		return "addbook";
         }
    	
    	repository.save(book); 
    	return "redirect:booklist"; 
    } 

    @RequestMapping(value = "/editSave", method = RequestMethod.POST) 
    public String editSave(@Valid Book book, BindingResult bindingResult, Model model){ 
    	 if (bindingResult.hasErrors()) {
    		log.info("VIRHE");
    		model.addAttribute("categories", crepository.findAll());
    		return "editbook";
         }
    	
    	repository.save(book); 
    	return "redirect:booklist"; 
    } 
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET) 
    public String deleteStudent(@PathVariable("id") Long bookId, Model model) { 
    	repository.deleteById(bookId); 
    	return "redirect:../booklist"; 
    }
    
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "index";
    }

    @RequestMapping(value="/index", method=RequestMethod.POST)
    public String addBookSubmit(@Valid Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
        	return "result";
        }
        
    	model.addAttribute("book", book);
        return "result";
    }
	
}

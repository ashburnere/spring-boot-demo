package com.ashburnere.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * Next, let's have a look at a web tier – and we'll start that by setting up a
 * simple controller – the BookController.
 * 
 * We'll implement basic CRUD operations exposing Book resources with some
 * simple validation:
 * 
 * Given this aspect of the application is an API, we made use of
 * the @RestController annotation here – which equivalent to a @Controller along
 * with @ResponseBody – so that each method marshals the returned resource right
 * to the HTTP response.
 * 
 * Just one note worth pointing out – we're exposing our Book entity as our
 * external resource here. That's fine for our simple application here, but in a
 * real-world application, you will likely want to separate these two concepts.
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping
	public Iterable findAll() {
		return bookRepository.findAll();
	}

	@GetMapping("/title/{bookTitle}")
	public List findByTitle(@PathVariable String bookTitle) {
		return bookRepository.findByTitle(bookTitle);
	}

	@GetMapping("/{id}")
	public Book findOne(@PathVariable Long id) {
		return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Book create(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
		bookRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
		if (book.getId() != id) {
			throw new BookIdMismatchException();
		}
		bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
		return bookRepository.save(book);
	}
}

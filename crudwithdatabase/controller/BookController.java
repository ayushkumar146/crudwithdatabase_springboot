package com.crudwithdatabase.crudwithdatabase.controller;

import com.crudwithdatabase.crudwithdatabase.model.Book;
import com.crudwithdatabase.crudwithdatabase.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST Controller to handle HTTP requests for Book operations.
 *
 * - @RestController: Marks this class as a REST API controller.
 * - @RequestMapping("/books"): Base URL for all endpoints.
 */
@RestController
@RequestMapping("/books")
class BookController {

    private final BookService bookService;  // Injected service instance

    /**
     * Constructor-based Dependency Injection.
     */
    public BookController(BookService bookService) { // isme request body se kuch assign nhi krna apne ko bus BookService ke methods ko use krne ka access chahiye.
        this.bookService = bookService;
    }

    /**
     * Creates a new book.
     * @param book - JSON request body mapped to Book object
     * @return Created book
     */
    @PostMapping
    public Book createBook(@RequestBody Book book) { // book object ke bnte hi, jo data postman me dia tha, wo data constructor jo Book.java me h ke through is book object me aajaega
        return bookService.addBook(book);
    }

    /**
     * Retrieves all books.
     * @return List of books
     */
    @GetMapping
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    /**
     * Retrieves a book by its ID.
     * @param id - Book ID
     * @return Book object if found
     */
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    /**
     * Updates a book by ID.
     * @param id - Book ID
     * @param book - Updated book data
     * @return Updated book
     */
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    /**
     * Deletes a book by ID.
     * @param id - Book ID
     * @return Success or failure message
     */
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id) ? "Book deleted" : "Book not found";
    }
}

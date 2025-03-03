package com.crudwithdatabase.crudwithdatabase.service;


import com.crudwithdatabase.crudwithdatabase.model.Book;
import com.crudwithdatabase.crudwithdatabase.repository.BookRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

/**
 * Service class to handle business logic for Book operations.
 *
 * - @Service: Marks this class as a Spring-managed service component.
 * - Dependency Injection: BookRepository is injected to interact with the database.
 */
@Service
public class BookService {

    private final BookRepository bookRepository;  // Injected repository instance


    /**
     * Constructor-based Dependency Injection.
     * Spring automatically injects BookRepository when creating BookService.
     */
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Creates a new book in the database.
     * @param book - Book object to be added
     * @return saved book
     */
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * Retrieves all books from the database.
     * @return list of books
     */
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * Retrieves a book by its ID.
     * @param id - Book ID
     * @return Optional containing book if found, otherwise empty
     */
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    /**
     * Updates an existing book.
     * @param id - Book ID to update
     * @param updatedBook - New book data
     * @return Updated book if found, otherwise null
     */
    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    return bookRepository.save(book);
                }).orElse(null);
    }

    /**
     * Deletes a book by its ID.
     * @param id - Book ID
     * @return true if deleted, false if book not found
     */
    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

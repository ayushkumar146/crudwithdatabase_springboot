package com.crudwithdatabase.crudwithdatabase.repository;

 import com.crudwithdatabase.crudwithdatabase.model.Book;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;


/**
 * Repository interface for handling database operations on the "books" table.
 *
 * - JpaRepository<Book, Long>: Provides built-in CRUD operations.
 * - @Repository: Marks this as a Spring-managed repository component.
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Long>{
}

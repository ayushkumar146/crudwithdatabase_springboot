package com.crudwithdatabase.crudwithdatabase.model;

import jakarta.persistence.*;

/**
 * Entity class representing the "books" table in the database.
 */
@Entity  // Marks this class as a JPA entity (table in the database)
@Table(name = "books")  // Specifies the table name in the database
public class Book {

    @Id  // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increments the ID
    private Long id;

    @Column(nullable = false)  // Ensures the title column is NOT NULL
    private String title;

    @Column(nullable = false)  // Ensures the author column is NOT NULL
    private String author;

    /**
     * Default constructor (required by JPA).
     */
    public Book() {}

    /**
     * Parameterized constructor to initialize a book object.
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters and Setters (used to access and modify private fields)

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}


package com.example.EgzaminoPavizdinisDarbas.entity;


import javax.persistence.*;

@Table(name = "book")
@Entity
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "name")
    private String bookName;

    @Column(name = "summary", columnDefinition = "text")
    private String bookSummary;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "photo")
    private String bookPhoto;

    @Column(name = "page_number")
    private int bookPageNumber;

    @Column(name = "is_available")
    private boolean available;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name ="category_id")
    private Category category;

    public Book() {
    }

    public Book(int id, String bookName, String bookSummary, String isbn, int bookPageNumber, boolean available) {
        this.id = id;
        this.bookName = bookName;
        this.bookSummary = bookSummary;
        this.isbn = isbn;
        this.bookPageNumber = bookPageNumber;
        this.available = available;
    }

    public Book(String bookName, String bookSummary, String isbn, int bookPageNumber) {
        this.bookName = bookName;
        this.bookSummary = bookSummary;
        this.isbn = isbn;
        this.bookPageNumber = bookPageNumber;
    }

    public Book(String bookName, String bookSummary, String isbn, int bookPageNumber, boolean available) {
        this.bookName = bookName;
        this.bookSummary = bookSummary;
        this.isbn = isbn;
        this.bookPageNumber = bookPageNumber;
        this.available = available;
    }

    public Book(String bookName, String bookSummary, String isbn, String bookPhoto, int bookPageNumber, boolean available) {
        this.bookName = bookName;
        this.bookSummary = bookSummary;
        this.isbn = isbn;
        this.bookPhoto = bookPhoto;
        this.bookPageNumber = bookPageNumber;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookSummary() {
        return bookSummary;
    }

    public void setBookSummary(String bookSummary) {
        this.bookSummary = bookSummary;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookPhoto() {
        return bookPhoto;
    }

    public void setBookPhoto(String bookPhoto) {
        this.bookPhoto = bookPhoto;
    }

    public int getBookPageNumber() {
        return bookPageNumber;
    }

    public void setBookPageNumber(int bookPageNumber) {
        this.bookPageNumber = bookPageNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookSummary='" + bookSummary + '\'' +
                ", isbn='" + isbn + '\'' +
                ", bookPhoto='" + bookPhoto + '\'' +
                ", bookPageNumber=" + bookPageNumber +
                ", available=" + available +
                ", category=" + category +
                '}';
    }
}

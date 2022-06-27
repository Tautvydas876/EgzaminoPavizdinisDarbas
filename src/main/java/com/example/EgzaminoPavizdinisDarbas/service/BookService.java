package com.example.EgzaminoPavizdinisDarbas.service;

import com.example.EgzaminoPavizdinisDarbas.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    List<Book> findAllAvailableBooks();

    Book save(Book book);

    void delete(Book book);

    Book findBookById(int id);

    void updateBookByID(String name, int pageNumber,String summary, String isbn, int id);
}

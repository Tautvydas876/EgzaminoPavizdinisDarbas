package com.example.EgzaminoPavizdinisDarbas.service;


import com.example.EgzaminoPavizdinisDarbas.dao.BookRepository;
import com.example.EgzaminoPavizdinisDarbas.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findAllAvailableBooks() {
        return bookRepository.findAllByAvailableIsTrue();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book findBookById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void updateBookByID(String name, int pageNumber, String summary, String isbn, int id) {
        bookRepository.updateBookByID(name,pageNumber,summary,isbn,id);

    }
}

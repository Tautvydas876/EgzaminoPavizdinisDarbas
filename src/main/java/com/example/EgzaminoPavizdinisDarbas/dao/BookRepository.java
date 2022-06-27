package com.example.EgzaminoPavizdinisDarbas.dao;

import com.example.EgzaminoPavizdinisDarbas.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface BookRepository extends JpaRepository<Book, Integer> {

    @Override
    List<Book> findAll();

    List<Book> findAllByAvailableIsTrue();

    Book findById(int id);


    @Query("update Book a set  a.bookName=:name, a.bookPageNumber=:page, a.bookSummary=:summary, a.isbn=:isbn where a.id=:id")
    void updateBookByID(@Param("name") String name, @Param("page") int pageNumber, @Param("summary") String summary, @Param("isbn") String isbn, @Param("id") int id);

}

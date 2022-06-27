package com.example.EgzaminoPavizdinisDarbas.service;

import com.example.EgzaminoPavizdinisDarbas.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    void deleteById(int id);

    void save(Category category);

    Category findCategoryByName(String name);
}

package com.example.EgzaminoPavizdinisDarbas.dao;

import com.example.EgzaminoPavizdinisDarbas.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByName(String name);
}

package ir.equadesign.todoapp.services;

import ir.equadesign.todoapp.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
}

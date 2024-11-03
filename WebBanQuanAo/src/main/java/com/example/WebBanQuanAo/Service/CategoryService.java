package com.example.WebBanQuanAo.Service;

import com.example.WebBanQuanAo.Entity.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCate();
    String insertCate(Category category);
    String updateCate(Category category);
    String deleteCate(int idCate);
}

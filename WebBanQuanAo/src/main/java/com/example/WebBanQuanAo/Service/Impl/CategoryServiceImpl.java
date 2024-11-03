package com.example.WebBanQuanAo.Service.Impl;

import com.example.WebBanQuanAo.Entity.Category;
import com.example.WebBanQuanAo.Repository.CategoryRepository;
import com.example.WebBanQuanAo.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCate() {
        return categoryRepository.findAll();
    }

    @Override
    public String insertCate(Category category) {
        Category newObj = new Category();
        newObj.setIdCategories(0);
        newObj.setCateName(category.getCateName());
        newObj.setDes(category.getDes());
        categoryRepository.save(newObj);
        return "Success";
    }

    @Override
    public String updateCate(Category category) {
        Category getCate = categoryRepository.findById(category.getIdCategories()).get();
        if(getCate != null){
            getCate.setCateName(category.getCateName());
            getCate.setDes(category.getDes());
            categoryRepository.save(getCate);
            return "Success";
        }else{
            return "Không tìm thấy categories";
        }
    }

    @Override
    public String deleteCate(int idCate) {
        Category getCate = categoryRepository.findById(idCate).get();
        if(getCate != null){
            categoryRepository.delete(getCate);
            return "Success";
        }else{
            return "Không tìm thấy categories";
        }
    }
}

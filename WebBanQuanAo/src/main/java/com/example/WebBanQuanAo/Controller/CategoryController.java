package com.example.WebBanQuanAo.Controller;

import com.example.WebBanQuanAo.Entity.Category;
import com.example.WebBanQuanAo.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/getAllCategory")
    public List<Category> getAllCate(){
        return categoryService.getAllCate();
    }
    @PostMapping("/insertCate")
    public String insertCate(@RequestBody Category category){
        return categoryService.insertCate(category);
    }
    @PutMapping("/updateCate")
    public String updateCate(@RequestBody Category category){
        return categoryService.updateCate(category);
    }
    @DeleteMapping("/deleteCate/{IDCate}")
    public String deleteCate(@PathVariable int IDCate){
        return categoryService.deleteCate(IDCate);
    }
}

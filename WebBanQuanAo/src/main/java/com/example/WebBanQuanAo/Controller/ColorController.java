package com.example.WebBanQuanAo.Controller;
import com.example.WebBanQuanAo.Entity.Color;
import com.example.WebBanQuanAo.Service.ColorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class ColorController {
    @Autowired
    private ColorService colorService;
    @GetMapping("/getAllColor")
    public List<Color> getAllColor(){
        return colorService.getAllColor();
    }
    @PostMapping("/insertColor")
    public String insertColor(@RequestBody Color color){
        return colorService.insertColor(color);
    }
    @PutMapping("/updateColor")
    public String updateColor(@RequestBody Color color){
        return colorService.updateColor(color);
    }
    @DeleteMapping("/deleteColor/{IDColor}")
    public String deleteColor(@PathVariable int IDColor){
        return colorService.deleteColor(IDColor);
    }
}

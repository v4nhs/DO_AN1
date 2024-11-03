package com.example.WebBanQuanAo.Controller;
import com.example.WebBanQuanAo.Entity.Size;
import com.example.WebBanQuanAo.Service.SizeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class SizeController {
    @Autowired
    private SizeService sizeService;
    @GetMapping("/getAllSize")
    public List<Size> getAllSize(){
        return sizeService.getAllSize();
    }
    @PostMapping("/insertSize")
    public String insertSize(@RequestBody Size size){
        return sizeService.insertSize(size);
    }
    @PutMapping("/updateSize")
    public String updateSize(@RequestBody Size size){
        return sizeService.updateSize(size);
    }
    @DeleteMapping("/deleteSize/{IDSize}")
    public String deleteSize(@PathVariable int IDSize){
        return sizeService.deleteSize(IDSize);
    }
}

package com.example.WebBanQuanAo.Service.Impl;

import com.example.WebBanQuanAo.Entity.Color;
import com.example.WebBanQuanAo.Repository.ColorRespository;
import com.example.WebBanQuanAo.Service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    private ColorRespository colorRespository;
    @Override
    public List<Color> getAllColor() {
        return colorRespository.findAll();
    }

    @Override
    public String insertColor(Color color) {
        Color newObj = new Color();
        newObj.setIdColor(0);
        newObj.setColorName(color.getColorName());
        newObj.setDes(color.getDes());
        colorRespository.save(newObj);
        return "Thêm thành công";
    }

    @Override
    public String updateColor(Color color) {
        Color getColor = colorRespository.findById(color.getIdColor()).get();
        if(getColor != null){
            getColor.setColorName(color.getColorName());
            getColor.setDes(color.getDes());
            colorRespository.save(getColor);
            return "Success";
        }else{
            return "Không tìm thấy";
        }
    }

    @Override
    public String deleteColor(int idColor) {
        Color getColor = colorRespository.findById(idColor).get();
        if(getColor != null){
            colorRespository.delete(getColor);
            return "Success";
        }else{
            return "Không tìm thấy";
        }
    }
}

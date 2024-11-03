package com.example.WebBanQuanAo.Service.Impl;

import com.example.WebBanQuanAo.Entity.Size;
import com.example.WebBanQuanAo.Repository.SizeRespository;
import com.example.WebBanQuanAo.Service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SizeServiceImpl implements SizeService {
    @Autowired
    private SizeRespository sizeRespository;
    @Override
    public List<Size> getAllSize() {
        return sizeRespository.findAll();
    }

    @Override
    public String insertSize(Size size) {
        Size newObj = new Size();
        newObj.setIdSize(0);
        newObj.setSizeName(size.getSizeName());
        newObj.setDes(size.getDes());
        sizeRespository.save(newObj);
        return "Success";
    }

    @Override
    public String updateSize(Size size) {
        Size getSize = sizeRespository.findById(size.getIdSize()).get();
        if(getSize != null){
            getSize.setSizeName(size.getSizeName());
            getSize.setDes(size.getDes());
            sizeRespository.save(getSize);
            return "Success";
        }else{
            return "Không tìm thấy";
        }
    }

    @Override
    public String deleteSize(int idSize) {
        Size getSize = sizeRespository.findById(idSize).get();
        if(getSize != null){
            sizeRespository.delete(getSize);
            return "Success";
        }else{
            return "Không tìm thấy";
        }
    }
}

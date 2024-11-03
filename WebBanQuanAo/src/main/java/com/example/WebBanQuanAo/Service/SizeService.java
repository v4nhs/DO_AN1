package com.example.WebBanQuanAo.Service;

import com.example.WebBanQuanAo.Entity.Size;

import java.util.List;

public interface SizeService {
    List<Size> getAllSize();
    String insertSize(Size size);
    String updateSize(Size size);
    String deleteSize(int idSize);
}

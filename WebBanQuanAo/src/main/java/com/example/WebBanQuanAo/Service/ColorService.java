package com.example.WebBanQuanAo.Service;

import com.example.WebBanQuanAo.Entity.Color;

import java.util.List;

public interface ColorService {
    List<Color> getAllColor();
    String insertColor(Color color);
    String updateColor(Color color);
    String deleteColor(int idColor);
}

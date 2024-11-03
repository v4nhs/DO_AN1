package com.example.WebBanQuanAo.Repository;

import com.example.WebBanQuanAo.Entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRespository extends JpaRepository<Color, Integer> {
}

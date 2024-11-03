package com.example.WebBanQuanAo.Repository;

import com.example.WebBanQuanAo.Entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRespository extends JpaRepository<Size, Integer> {
}

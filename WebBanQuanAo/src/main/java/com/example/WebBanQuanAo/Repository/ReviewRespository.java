package com.example.WebBanQuanAo.Repository;

import com.example.WebBanQuanAo.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRespository extends JpaRepository<Review, Integer> {
}

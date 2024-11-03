package com.example.WebBanQuanAo.Repository;

import com.example.WebBanQuanAo.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRespository extends JpaRepository<Comment, Integer> {
}

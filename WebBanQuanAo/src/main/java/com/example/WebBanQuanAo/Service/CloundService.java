package com.example.WebBanQuanAo.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloundService {
    String uploadImage(MultipartFile file) throws IOException;
}

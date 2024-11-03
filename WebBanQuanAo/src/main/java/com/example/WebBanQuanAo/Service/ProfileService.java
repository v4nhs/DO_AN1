package com.example.WebBanQuanAo.Service;

import com.example.WebBanQuanAo.Entity.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProfileService {
    ResponseEntity<?> editProfile(Profile profile);
    String updateImage(int idProfile, MultipartFile avt) throws IOException;


}

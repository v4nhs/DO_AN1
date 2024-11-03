package com.example.WebBanQuanAo.Controller;
import com.example.WebBanQuanAo.Entity.Profile;
import com.example.WebBanQuanAo.Service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
@AllArgsConstructor
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @PutMapping("/updateProfile")
    public ResponseEntity<?> updateProfile(@RequestBody Profile profile){
        return profileService.editProfile(profile);
    }
    @PutMapping("/updateAvtProfile")
    public String updateImageProfile(@RequestParam("idProfile") int idProfile,
                                     @RequestParam("avt") MultipartFile avt) throws IOException {
        return profileService.updateImage(idProfile, avt);
    }
}

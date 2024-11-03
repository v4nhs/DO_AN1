package com.example.WebBanQuanAo.Service.Impl;

import com.example.WebBanQuanAo.Entity.Profile;
import com.example.WebBanQuanAo.Repository.ProfileRepository;
import com.example.WebBanQuanAo.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private CloundServiceImpl cloundService;
    @Override
    public ResponseEntity<?> editProfile(Profile profile) {
        Optional<Profile> getProfile = profileRepository.findById(profile.getIDProfile());
        if(getProfile.isPresent()){
            Profile profile1 = getProfile.get();
            profile1.setAddress(profile.getAddress());
            profile1.setDof(profile.getDof());
            profile1.setEmail(profile.getEmail());
            profile1.setFullName(profile.getFullName());
            profile1.setPhone(profile.getPhone());
            profileRepository.save(profile1);
            return new ResponseEntity<>(profile1, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Không tìm thấy", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public String updateImage(int idProfile, MultipartFile avt) throws IOException {
        Optional<Profile> profile = profileRepository.findById(idProfile);
        if(profile.isPresent()){
            Profile getProfile = profile.get();
            getProfile.setAvt(cloundService.uploadImage(avt));
            profileRepository.save(getProfile);
            return "Success";
        }else{
            return "Không tìm thấy";
        }
    }
}

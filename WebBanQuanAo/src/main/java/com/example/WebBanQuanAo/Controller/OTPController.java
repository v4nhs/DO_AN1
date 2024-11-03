package com.example.WebBanQuanAo.Controller;

import com.example.WebBanQuanAo.Entity.Profile;
import com.example.WebBanQuanAo.Repository.ProfileRepository;
import com.example.WebBanQuanAo.Service.AccountService;
import com.example.WebBanQuanAo.Service.Impl.EmailService;
import com.example.WebBanQuanAo.Service.Impl.OTPService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class OTPController {
    @Autowired
    public OTPService otpService;

    @Autowired
    public EmailService emailService;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private AccountService accountService;

    @PostMapping("/generateOtp")
    public ResponseEntity<String> generateOTP(@RequestParam("email") String email) throws MessagingException {
        Profile checkUser = profileRepository.findByGmail(email);
        if(checkUser != null)
        {

            int otp = otpService.generateOTP(checkUser.getEmail());
            System.out.println(checkUser.getEmail());
            System.out.println(otp);
            Context context = new Context();
            context.setVariable("otpvalue", otp);
            emailService.sendEmailOTP(email, "Send OTP", context);
            return new ResponseEntity<>("OTP generated and sent successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Không tìm thấy tài khoản", HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/validateOtp")
    public ResponseEntity<String> validateOtp(@RequestParam("otpnum") int otpnum, @RequestParam("email") String email) {
        Profile checkUser = profileRepository.findByGmail(email);
        if(checkUser != null){
            final String SUCCESS = "Success";
            final String FAIL = "Fail";
            // Validate the Otp
            if (otpnum >= 0) {
                int serverOtp = otpService.getOtp(checkUser.getEmail());
                if (serverOtp > 0) {
                    if (otpnum == serverOtp) {
                        otpService.clearOTP(checkUser.getEmail());
                        return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST);
                    }
                } else {
                    return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST);
            }
        }else{
            return new ResponseEntity<>("Không tìm thấy tài khoản", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/changePassword")
    public String changePass(@RequestParam("email") String email,
                             @RequestParam("newPass") String pass){
        return accountService.changePass(email, pass);
    }
}

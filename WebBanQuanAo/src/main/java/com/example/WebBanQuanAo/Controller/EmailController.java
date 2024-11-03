package com.example.WebBanQuanAo.Controller;

import com.example.WebBanQuanAo.Entity.Account;
import com.example.WebBanQuanAo.Entity.Profile;
import com.example.WebBanQuanAo.Repository.AccountRepository;
import com.example.WebBanQuanAo.Repository.ProfileRepository;
import com.example.WebBanQuanAo.Service.AccountService;
import com.example.WebBanQuanAo.Service.Impl.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@AllArgsConstructor
public class EmailController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @PostMapping("/register")
    public String register(@RequestParam("username") String userName,
                           @RequestParam("password") String passWord,
                           @RequestParam("email") String email) {
        Account existingAccount = accountRepository.findByUserName(userName);
        Profile existingProfile = profileRepository.findByGmail(email);

        if (existingProfile != null) {
            return "Email đã tồn tại";
        }
        if (existingAccount != null) {
            return "Tài khoản đã tồn tại";
        }

        String result = accountService.register(userName, passWord, email);
        return result.equals("Success") ? "Đăng ký thành công" : "Đăng ký thất bại";
    }

    @GetMapping("/confirm-registration")
    public RedirectView confirm(@RequestParam("name") String name,
                                @RequestParam("pass") String pass,
                                @RequestParam("email") String email){
        System.out.println(name);
        System.out.println(pass);
        System.out.println(email);
        String result = accountService.register(name, pass, email);
        if(result.equals("Success")){
            return new RedirectView("http://localhost:3002/login");
        }else{
            return new RedirectView("http://localhost:3002/register?error=" + result);
        }
    }
}

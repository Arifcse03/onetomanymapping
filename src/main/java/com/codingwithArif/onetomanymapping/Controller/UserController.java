package com.codingwithArif.onetomanymapping.Controller;

import com.codingwithArif.onetomanymapping.Entity.User;
import com.codingwithArif.onetomanymapping.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    UserRepo userRepo;


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
//        model.addAttribute("user", new User());
        return "registration";
    }

    @GetMapping("/login")
    public String showLoginpage(Model model) {
//        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/login")
    public String loginToGo( @RequestParam("username") String username, @RequestParam("password") String password) {



        return "redirect:/posts";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@RequestParam("email") String email, @RequestParam("username") String username, @RequestParam("password") String password) {
        // Process the user registration here
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = md.digest(password.getBytes());
            String encodedPassword = Base64.getEncoder().encodeToString(hashedPassword);
            System.out.println(encodedPassword);
            User user = new User();
            user.setEmail(email);
            user.setUsername(username);
            user.setPassword(encodedPassword);
            userRepo.save(user);
            return "redirect:/login";
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(email + username + password);

        return "redirect:/register";
    }


}

package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController
{

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm()
    {
        return "redirect:/login.html";
    }


    @PostMapping("/login")
    public RedirectView login(@RequestParam String login, @RequestParam String password)
    {
        User foundUser = userRepository.findById(login).orElse(null);
        if (foundUser != null && PasswordUtils.comparePassword(password,foundUser.getPassword()))
        {
            return new RedirectView("loginSuccess.html");
        }
        else
        {

            return new RedirectView("loginFailed.html");
        }
    }

}
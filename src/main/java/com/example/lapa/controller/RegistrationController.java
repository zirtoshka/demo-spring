package com.example.lapa.controller;

import com.example.lapa.domain.Role;
import com.example.lapa.domain.User;
import com.example.lapa.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration() {
        System.out.println("\u001B[41m"+"lop"+"\u001B[0m");
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());
        System.out.println("\u001B[41m"+"jopaaaaa"+"\u001B[0m");

        if (userFromDb != null) {
            System.out.println("\u001B[41m"+"жопа есть"+"\u001B[0m");

            model.put("message", "User exists!");
            return "registration";
        }
        System.out.println("\u001B[41m"+"жопы нет"+"\u001B[0m");
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        System.out.println("\u001B[41m"+"жопа сохранилась"+"\u001B[0m");
        return "redirect:/login";
    }
}
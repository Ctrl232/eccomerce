package com.codea.eccomerce.aplication.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;

public class LogoutService {
    public LogoutService(){

    }

    public void logout(HttpSession httpSession){
        httpSession.removeAttribute("iduser") ;
    }
}

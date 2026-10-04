package com.authentication.authentication.Controller;

import com.authentication.authentication.Model.User;
import com.authentication.authentication.Service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {

        return authService.register(user);
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password
    ) {

        return authService.login(email, password);
    }
}
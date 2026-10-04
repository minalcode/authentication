package com.authentication.authentication.Controller;

import com.authentication.authentication.Security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    private final JwtUtil jwtUtil;

    public RoleController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @GetMapping
    public String getRole(
            @RequestHeader("Authorization") String authorization
    ) {

        String token = authorization.substring(7);

        String email = jwtUtil.extractEmail(token);

        return "Authenticated user: " + email;
    }
}
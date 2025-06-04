package com.v2soft.vpmt.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    @GetMapping
    public String dashboard() {
        return "Dashboard data";
    }
}

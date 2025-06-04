package com.v2soft.vpmt.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/report")
public class ReportController {
    @GetMapping
    public String report() {
        return "Report data";
    }
}

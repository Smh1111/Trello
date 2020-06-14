package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class TimeModelController {

    @GetMapping
    public Map<String, String> getVersion() {
        Map<String, String> app = new HashMap<>();
        app.put("name", "Trello Example");
        app.put("description", "CRUD REST API for Trello");
        app.put("version", "v1.0");
        return app;
    }

}

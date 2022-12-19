package com.practise.productservice.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProductController
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @PostMapping
    public String createMapping() {
        return "HTTP POST created";
    }    

    @GetMapping
    public String getMapping() {
        return "HTTP GET request";
    }

    @PutMapping
    public String updateMapping() {
        return "HTTP PUT request";
    }

    @DeleteMapping
    public String deleteMapping() {
        return "HTTP DELETE requested";
    }
}
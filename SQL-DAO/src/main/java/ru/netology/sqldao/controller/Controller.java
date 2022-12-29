package ru.netology.sqldao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.sqldao.repository.Repository;

import java.util.List;

@RestController
public class Controller {
    Repository repository;
    public Controller (Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> fetchProduct(String name) {
        return repository.getProductName(name);
    }
}

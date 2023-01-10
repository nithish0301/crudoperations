package com.example.crudoperation.controller;

import com.example.crudoperation.entity.Product;
import com.example.crudoperation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productservice;

    @GetMapping("/list")

    public ResponseEntity<List<Product>> getAllproduct() {
        try {
            return new ResponseEntity<>(productservice.getAllproduct(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @PostMapping("/list/add")
    public ResponseEntity<Product> Addproduct(@RequestBody Product prod) {
        try {
            return new ResponseEntity<>(productservice.Addproduct(prod), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @PutMapping("/list/{id}")
    public ResponseEntity<String> updateProduct(@RequestBody Product prod, @PathVariable("id") String productid) {
        try {
            return new ResponseEntity<>(productservice.updateProduct(prod, productid), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @DeleteMapping("/list/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") String productid) {
        try {
            productservice.deleteProduct(productid);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productid + " was deleted", HttpStatus.OK);


    }
}

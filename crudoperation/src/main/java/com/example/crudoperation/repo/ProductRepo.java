package com.example.crudoperation.repo;

import com.example.crudoperation.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepo extends MongoRepository<Product, String> {
    public List<Product> findByproductId(Integer id);

    public void delete(Product foundproduct);
}

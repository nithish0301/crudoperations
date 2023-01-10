package com.example.crudoperation.service;

import com.example.crudoperation.entity.Product;
import com.example.crudoperation.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    @Autowired
    public ProductRepo prodrepo;

    public List<Product> getAllproduct() {
        return prodrepo.findAll();

    }



    public Product Addproduct(Product product) {

        return prodrepo.save(product);
    }

    public String updateProduct(Product product, String productid) {
        Optional<Product> productData = prodrepo.findById(productid);
        if (productData.isPresent()) {
            Product produ = productData.get();
            produ.setProductName(product.getProductName());
            produ.setProductPrice(product.getProductPrice());

            this.prodrepo.save(produ);
            return "Product details are updated";
        } else {
            return "Product detail is not updated";
        }


    }

    public String deleteProduct(String productid) {
        prodrepo.deleteById(productid);
        return productid + " was deleted successfully";
    }

    public List<Product> getfarmer(Integer productid) {

        return prodrepo.findByproductId(productid);
    }
}
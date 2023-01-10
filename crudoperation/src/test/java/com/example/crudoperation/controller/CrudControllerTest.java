package com.example.crudoperation.controller;

import com.example.crudoperation.entity.Product;
import com.example.crudoperation.repo.ProductRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class CrudControllerTest {
    @InjectMocks
    public ProductController ProductController = Mockito.mock(ProductController.class);

    @Mock
    public ProductRepo prodrepo;

    Product F =new Product("22","kamal",200);

    public ResponseEntity<List<Product>> getlist(){
        List<Product> testProduct = new ArrayList<Product>();
        testProduct.add(F);
        Product s = new Product("22","kamal",400);
        testProduct.add(s);
        return new ResponseEntity<>(testProduct, HttpStatus.OK);    //generating & Returning Response
    }
    @Test
    void findById() {
        ResponseEntity<List<Product>> Response = getlist() ;
        List<Product> f = getlist().getBody();
        Product f1 = f.stream()
                .filter(product -> "2".equals(product.getProductId()))
                .findAny().orElse(null);
        assertThat(Response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(f1).isNotSameAs(F);
        // assertThat(f1.getId()).isNotNull();

    }

    @Test
    void addProduct() {
         Product s = new Product("3","product",500);
        when(ProductController.Addproduct(s)).thenReturn(new ResponseEntity<>(s,HttpStatus.OK));
        when(ProductController.Addproduct(F)).thenReturn(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
        ResponseEntity<Product> result1 = ProductController.Addproduct(F);
        ResponseEntity<Product> result = ProductController.Addproduct(s);
        assertThat(result1.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody().toString()).isEqualTo((s.toString()));
    }

    @Test
    void deleteProd() {
        when(ProductController.deleteProduct("1")).thenReturn(new ResponseEntity<>("Deleted SuccessFully",HttpStatus.OK));
        when(ProductController.deleteProduct("2")).thenReturn(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        ResponseEntity<String> result1 = ProductController.deleteProduct("1");
        ResponseEntity<String> result = ProductController.deleteProduct("2");
        assertThat(result1.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

}

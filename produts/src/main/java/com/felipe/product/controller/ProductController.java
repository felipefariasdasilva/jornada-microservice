package com.felipe.product.controller;

import com.felipe.product.model.Product;
import com.felipe.product.model.form.ProductForm;
import com.felipe.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity getProducts(){
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getProductsById(){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity postProducts(ProductForm productForm, UriComponentsBuilder uriComponentsBuilder){

        Product product = productForm.convert();
        productRepository.save(product);

        URI uri = uriComponentsBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity updateProducts(){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteProducts(){
        return ResponseEntity.ok().build();
    }
}

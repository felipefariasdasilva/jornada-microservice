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

    @GetMapping("/{id}")
    public ResponseEntity getProductsById(@PathVariable String id){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity postProducts(ProductForm productForm, UriComponentsBuilder uriComponentsBuilder){

        System.out.println(productForm);
        Product product = productForm.convert();
        productRepository.save(product);

        URI uri = uriComponentsBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProducts(@PathVariable String id){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProducts(@PathVariable String id){
        return ResponseEntity.ok().build();
    }
}

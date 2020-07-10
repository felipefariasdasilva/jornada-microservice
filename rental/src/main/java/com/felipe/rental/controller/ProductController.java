package com.felipe.rental.controller;

import com.felipe.rental.model.Product;
import com.felipe.rental.model.form.ProductForm;
import com.felipe.rental.repository.ProductRepository;
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
    public ResponseEntity postProducts(@RequestBody ProductForm productForm, UriComponentsBuilder uriComponentsBuilder){

        Product product = productForm.convert();
        productRepository.save(product);

        URI uri = uriComponentsBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProductForm(product));
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

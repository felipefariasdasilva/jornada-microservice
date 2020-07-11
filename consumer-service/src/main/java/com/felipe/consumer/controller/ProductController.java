package com.felipe.consumer.controller;

import com.felipe.consumer.model.Order;
import com.felipe.consumer.model.Product;
import com.felipe.consumer.model.dto.ProductDTO;
import com.felipe.consumer.model.form.ProductForm;
import com.felipe.consumer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<ProductDTO> getProducts(){
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();

        products.forEach(product -> productDTOS.add(new ProductDTO(product)));

        return productDTOS;
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
        return ResponseEntity.created(uri).body(new ProductDTO(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProducts(@PathVariable String id){
        Optional<Product> productById = productRepository.findById(UUID.fromString(id));
        return productById.isPresent() ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProducts(@PathVariable String id){
        return ResponseEntity.ok().build();
    }
}

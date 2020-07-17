package com.felipe.product.controller;

import com.felipe.product.model.Product;
import com.felipe.product.model.dto.ProductDTO;
import com.felipe.product.model.form.ProductForm;
import com.felipe.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pubsub.KafkaDispatcher;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<ProductDTO> getProducts(){
        List<Product> products = productRepository.findAll();
        System.out.println(products.size());
        List<ProductDTO> productDTOS = new ArrayList<>();

        for (Product product: products) {
            productDTOS.add(new ProductDTO(product));
        }

        return productDTOS;
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductsById(@PathVariable String id){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity postProducts(@RequestBody ProductForm productForm, UriComponentsBuilder uriComponentsBuilder) throws ExecutionException, InterruptedException, IOException {
        System.out.println("json: "+productForm.toString());
        Product product = productForm.convert();
        productRepository.save(product);

        KafkaDispatcher<Product> productDispatcher = new KafkaDispatcher<>();
        productDispatcher.send("PRODUCTSERVICE_NEW_PRODUCT", product.getId().toString(), product);

        URI uri = uriComponentsBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProductDTO(product));
    }


    @PutMapping("/{id}")
    public ResponseEntity updateProducts(@PathVariable String id){
        Optional<Product> productById = productRepository.findById(id);
        if(productById.isPresent()){
            System.out.println(productById.get());
        }else{
            System.out.println("nao achei");
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProducts(@PathVariable String id){
        Optional<Product> productById = productRepository.findById(id);
        if(productById.isPresent()){
            productRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}


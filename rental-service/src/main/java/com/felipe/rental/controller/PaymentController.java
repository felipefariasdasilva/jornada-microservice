package com.felipe.rental.controller;

import com.felipe.rental.model.Payment;
import com.felipe.rental.model.dto.PaymentDTO;
import com.felipe.rental.model.form.PaymentForm;
import com.felipe.rental.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping
    public ResponseEntity getPayments() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getPaymentsById(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity postPayments(@RequestBody PaymentForm paymentForm, UriComponentsBuilder uriComponentsBuilder) {

        Payment payment = paymentForm.convert();
        paymentRepository.save(payment);

        URI uri = uriComponentsBuilder.path("/payments/{id}").buildAndExpand(payment.getId()).toUri();
        return ResponseEntity.created(uri).body(new PaymentDTO(payment));
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePayments(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePayments(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }
}

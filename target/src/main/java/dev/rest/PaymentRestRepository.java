package dev.rest;

import dev.domain.Payment;

import dev.service.PaymentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PaymentRestRepository {


    private PaymentService paymentService;

    public PaymentRestRepository(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payments")
    public List<Payment> getPayments() {
        return paymentService.getAll();
    }

    @GetMapping("/payments/{paymentId}")
    public Payment getSpecificPayment(@PathVariable("paymentId") Integer paymentId) {
        return paymentService.get(paymentId);
    }

    @PutMapping("/payments/{paymentId}")
    public String UpdatePayment(@PathVariable("paymentId") Integer paymentId, @RequestBody Payment payment) {

        paymentService.edit(payment);
        return "Successful Payment Updated";
    }

    @DeleteMapping("/payments/{paymentId}")
    public String deletePayment(@PathVariable("paymentId") Integer paymentId) {
        paymentService.delete(paymentId);
        return "Successful";
    }

    @PostMapping("/payments")
    public String createPayment(@RequestBody Payment payment) {
        paymentService.create(payment);
        return "Successful";
    }
}

package dev.service;

import dev.domain.Hotel;
import dev.domain.Payment;
import dev.repository.HotelRepository;
import dev.repository.PaymentRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional

public class PaymentService {

    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void create(Payment payment) {
        payment.setPaymentId(payment.getPaymentId());
        paymentRepository.create(payment);
    }

    public List<Payment> getAll() {
        return paymentRepository.getAll();
    }

    public Payment get(int paymentId) {
        return paymentRepository.get(paymentId);
    }
    public void edit(Payment payment) {
        paymentRepository.edit(payment);
    }


    public void delete(int paymentId) {
        paymentRepository.delete(paymentId);
    }
}

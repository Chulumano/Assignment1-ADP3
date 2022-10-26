package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Payments;
import za.ac.cput.repository.PaymentsRepository;
import za.ac.cput.service.PaymentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImp implements PaymentService {

    private static PaymentService service;

    @Autowired
    private PaymentsRepository paymentsRepository;


    @Override
    public Payments create(Payments payments) {
        return this.paymentsRepository.save(payments);
    }

    @Override
    public Payments read(String paymentID) {
        return this.paymentsRepository.findById(paymentID)
                .orElse(null);
    }

    @Override
    public Payments update(Payments payments) {
        if (this.paymentsRepository.existsById(payments.getPaymentID()))
            return this.paymentsRepository.save(payments);
        return payments;
    }

    @Override
    public boolean delete(String paymentID) {
        this.paymentsRepository.deleteById(paymentID);
        if (this.paymentsRepository.existsById(paymentID)) {
            System.out.println("Payment: " + paymentID + " is not Deleted");
            return false;
        } else {
            System.out.println("Payment has been deleted");
            return true;
        }
    }

    @Override
    public List<Payments> findAll() {
        return this.paymentsRepository.findAll().stream().collect(Collectors.toList());
    }
}

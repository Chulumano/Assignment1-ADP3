package za.ac.cput.service;

import za.ac.cput.domain.Payments;

import java.util.List;

public interface PaymentService extends IService<Payments, String> {
    List<Payments> findAll();

}
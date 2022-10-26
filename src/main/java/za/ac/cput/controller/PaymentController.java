package za.ac.cput.controller;/*
Chulumanco Buhle Nkwindana 219390983
PaymentController.java
 */


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Payments;
import za.ac.cput.factory.PaymentsFactory;
import za.ac.cput.service.impl.PaymentServiceImp;
import java.util.List;

@RestController
@RequestMapping("payment/")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentServiceImp paymentService;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Payments create(@RequestBody Payments payments) {
        Payments newPayment = PaymentsFactory.createPayments(
                payments.getPaymentID(),
                payments.getPaymentType(),
                payments.getAmount(),
                payments.getCustomerID());
        return paymentService.create(newPayment);
    }

    @RequestMapping("/read/{paymentID}")
    public Payments read(@PathVariable String paymentID){
        return paymentService.read(paymentID);
    }


    @PostMapping("/update")
    public Payments update(@RequestBody  Payments payments)
    {return paymentService.update(payments);}


    @DeleteMapping("/delete/{paymentID}")
    public boolean delete(@PathVariable String paymentID) {
        return paymentService.delete(paymentID);}


    @GetMapping("/findAll")
    public List<Payments> findAll() {
        return paymentService.findAll();
    }

}

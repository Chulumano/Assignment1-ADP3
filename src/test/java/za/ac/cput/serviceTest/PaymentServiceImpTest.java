package za.ac.cput.serviceTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Payments;
import za.ac.cput.factory.PaymentsFactory;
import za.ac.cput.service.impl.PaymentServiceImp;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class PaymentServiceImpTest {

    @Autowired
    private PaymentServiceImp service;

    private final Payments payments =
            PaymentsFactory.createPayments(
                    "4585411",
                    "Cash",
                    "R47.00",
                    "472515");

    @Test
    void a_create() {
        Payments created = service.create(payments);
        assertEquals(created.getPaymentID(), payments.getPaymentID());
        System.out.println("created" + created);
    }

    @Test
    void b_read() {
        Payments read = service.read(payments.getPaymentID());
        assertNotNull(read);
        System.out.println("read:" + read);
    }

    //Possible error
    @Test
    void c_update() {
        Payments old = service.read("45121254");
        Payments updated = new Payments.Builder().copy(old)
                .setAmount("R600.58")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated amount " + "" + updated);

    }

    @Test
    void e_delete() {
        boolean done = service.delete("15954474");
        assertTrue(done);
        System.out.println("successfully deleted " + "" + done);

    }

    @Test
    void d_findAll() {
        System.out.println("Display all");
        System.out.println(service.findAll());

    }



}

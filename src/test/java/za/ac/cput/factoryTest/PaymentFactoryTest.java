package za.ac.cput.factoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payments;
import za.ac.cput.factory.PaymentsFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PaymentFactoryTest {

    @Test
    public void test(){
        Payments payments  = PaymentsFactory.createPayments(
                "745856",
                "EFT",
                "R584.55",
                "451256");
        System.out.println(payments.toString());
        assertNotNull(payments);

    }
}

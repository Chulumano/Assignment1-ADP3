package za.ac.cput.controllerTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Payments;
import za.ac.cput.factory.PaymentsFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class PaymentControllerTest {


    private static Payments payment1 = PaymentsFactory
            .createPayments("159753IR",
                    "Cash",
                    "R300.00",
                    "541224");



    private static Payments payment2 = PaymentsFactory
            .createPayments( "159654IR",
                    "Cheque",
                    "R500.90",
                    "541255");


    @Autowired
    private TestRestTemplate restTemplate;
    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String paymentURL = "http://localhost:8080/payment";

    private String username = "user";
    private String password = "password";




    @Test
    void a_create01() {
        String url = paymentURL + "/create";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Payments> httpEntity = new HttpEntity<>(payment1, httpHeaders);
        ResponseEntity<Payments> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Payments.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        payment1 = responseEntity.getBody();
        System.out.println("Payment Saved: "+payment1);
        assertEquals(payment1.getPaymentID(), responseEntity.getBody().getPaymentID());
    }

    @Test
    void b_create02() {
        String url = paymentURL + "/create";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Payments> httpEntity = new HttpEntity<>(payment2, httpHeaders);
        ResponseEntity<Payments> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Payments.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        payment2 = responseEntity.getBody();
        System.out.println("Payment Saved: "+payment2);
        assertEquals(payment2.getPaymentID(), responseEntity.getBody().getPaymentID());


    }

    @Test
    void c_read() {
        Payments c = null;
        String url = paymentURL + "/read/" +payment2.getPaymentID();
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Payments> request = new HttpEntity<>(c, httpHeaders);
        System.out.println("Url  " + url);
        ResponseEntity<Payments> responseCreate = restTemplate.postForEntity(url, request, Payments.class);
        assertNotNull(payment2.getPaymentID(), responseCreate.getBody().getPaymentID());


    }

    @Test
    void d_update() {
        Payments update = new Payments.Builder().copy((payment1)).setPaymentType("Credit").build();
        String url = paymentURL + "/update";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Payments> httpEntity = new HttpEntity<>(update, httpHeaders);
        System.out.println("Url used to update the payment: " + url);
        System.out.println("Updated payment: "+ update);
        ResponseEntity<Payments> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntity,Payments.class);
        assertNotNull(responseUpdate.getBody());

    }

    @Test
    void f_delete() {
        String url = paymentURL + "/delete" + payment1.getPaymentID();
        System.out.println("URL" + url);
        restTemplate.delete(url);
    }

    @Test
    void g_findAll() {
        String url = paymentURL + "/findAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                //basic config
                .withBasicAuth("user","password")
                .exchange(url, HttpMethod.GET, entity,String.class);
        System.out.println("Display All Entries");
        System.out.println(response);
        System.out.println(response.getBody());
    }



}

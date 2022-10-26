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
import za.ac.cput.domain.Tables;
import za.ac.cput.factory.TablesFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class TableControllerTest {


    private static Tables table1 = TablesFactory.createTables(
            "545451",
            "Available",
            "5",
            "Dining");

    private static Tables table2 = TablesFactory.createTables(
            "536851",
            "Occupied",
            "8",
            "Console");



    @Autowired
    private TestRestTemplate restTemplate;
    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String tableURL = "http://localhost:8080/table";

    private String username = "user";
    private String password = "password";

    @Test
    void a_create01() {
        String url = tableURL + "/create";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Tables> httpEntity = new HttpEntity<>(table1, httpHeaders);
        ResponseEntity<Tables> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Tables.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        table1 = responseEntity.getBody();
        System.out.println("Order Saved: "+table1);
        assertEquals(table1.getTableID(), responseEntity.getBody().getTableID());
    }

    @Test
    void b_create02() {
        String url = tableURL + "/create";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Tables> httpEntity = new HttpEntity<>(table2, httpHeaders);
        ResponseEntity<Tables> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Tables.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        table2 = responseEntity.getBody();
        System.out.println("Table Saved: "+table2);
        assertEquals(table2.getTableID(), responseEntity.getBody().getTableID());

    }

    @Test
    void c_read() {
        Tables o = null;
        String url = tableURL + "/read/" +table2.getTableID();
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Tables> request = new HttpEntity<>(o, httpHeaders);
        System.out.println("Url  " + url);
        ResponseEntity<Tables> responseCreate = restTemplate.postForEntity(url, request, Tables.class);
        assertNotNull(table2.getTableID(), responseCreate.getBody().getTableID());


    }

    @Test
    void d_update() {
        Tables update = new Tables.Builder().copy((table1)).setTableType("Bar").build();
        String url = tableURL + "/update";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Tables> httpEntity = new HttpEntity<>(update, httpHeaders);
        System.out.println("Url used to update the table: " + url);
        System.out.println("Updated table: "+ update);
        ResponseEntity<Tables> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntity,Tables.class);
        assertNotNull(responseUpdate.getBody());

    }

    @Test
    void f_delete() {
        String url = tableURL + "/delete" + table1.getTableID();
        System.out.println("URL" + url);
        restTemplate.delete(url);
    }

    @Test
    void g_findAll() {
        String url = tableURL + "/findAll";
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

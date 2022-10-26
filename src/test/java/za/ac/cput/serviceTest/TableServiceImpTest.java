package za.ac.cput.serviceTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Tables;
import za.ac.cput.factory.TablesFactory;
import za.ac.cput.service.impl.TableServiceImp;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class TableServiceImpTest {


    @Autowired
    private TableServiceImp service;

    private final Tables tables =
            TablesFactory.createTables(
                    "55678",
                    "Available",
                    "2",
                    "Picnic") ;



    @Test
    void a_create() {
        Tables created = service.create(tables);
        assertEquals(created.getTableID(), tables.getTableID());
        System.out.println("created" + created);
    }

    @Test
    void b_read() {
        Tables read = service.read(tables.getTableID());
        assertNotNull(read);
        System.out.println("read:" + read);
    }



    @Test
    void c_update() {
        Tables updated = new Tables.Builder().copy(tables)
                .setCapacity("5").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated table capacity"+ updated);
    }

    @Test
    void c_delete() {
        boolean done = service.delete("458215");
        assertTrue(done);
        System.out.println("successfully deleted " + "" + done);
    }

    @Test
    void g_findAll() {
        System.out.println("Display all");
        System.out.println(service.findAll());

    }


}

package za.ac.cput.factoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Tables;
import za.ac.cput.factory.TablesFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TableFactoryTest {

    @Test
    public void test(){
        Tables tables  = TablesFactory.createTables(
                "5851545",
                "Reserved",
                "5",
                "Coffee");
        System.out.println(tables.toString());
        assertNotNull(tables);

    }
}

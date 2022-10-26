package za.ac.cput.factory;
import za.ac.cput.domain.Tables;
import za.ac.cput.util.Helper2;

import java.util.UUID;
/* TablesFactory.Java
/ *  Entity for Tables
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 *  Date: 29 March 2022
 * */
public class TablesFactory {
    public static Tables createTables(String tableID,String tableStatus,String capacity,String tableType){
        if (Helper2.isNotEmpty(tableStatus) || Helper2.isNotEmpty(capacity)||Helper2.isNotEmpty(tableType)|| Helper2.isNotEmpty(tableID))
            return null;
        return new Tables.Builder()
                .setTableID(tableID)
                .setTableStatus(tableStatus)
                .setCapacity(capacity)
                .setTableStatus(tableStatus).build();
    }
}

package za.ac.cput.service;

/* Tables.Java
 *  Entity for Tables
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 * */
import za.ac.cput.domain.Tables;

import java.util.List;

public interface TableService extends IService<Tables, String>{
    List<Tables> findAll();
}

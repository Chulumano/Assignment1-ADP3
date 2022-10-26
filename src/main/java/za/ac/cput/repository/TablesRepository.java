package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Tables;

import java.util.Set;
/* TablesRepository.Java
 *  Entity for Tables
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 *  Date: 29 March 2022
 * */

@Repository
public interface TablesRepository extends JpaRepository<Tables, String> {


}

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Payments;

import java.util.Set;
/* PaymentsRepository.Java
 *  Entity for Payments
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 *  Date: 29 March 2022
 * */

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, String> {


}

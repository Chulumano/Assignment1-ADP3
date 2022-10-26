package za.ac.cput.factory;

import za.ac.cput.domain.Payments;
import za.ac.cput.util.Helper2;

import java.util.UUID;
/* PaymentsFactory.Java
 *  Entity for Tables
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 *  Date: 29 March 2022
 * */
public class PaymentsFactory {
    public static Payments createPayments(String customerID, String paymentType, String amount, String paymentID){
        if(Helper2.isNotEmpty(paymentID)|| Helper2.isNotEmpty(customerID)||Helper2.isNotEmpty(paymentType) )
            return null;



        return new Payments.Builder()

                .setPaymentID(paymentID)
                .setCustomerID(customerID)
                .setPaymentType(paymentType)
                .setAmount(amount)
                .build();
    }
}

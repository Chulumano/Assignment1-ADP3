package za.ac.cput.domain;

/* Payments.Java
 *  Entity for Payments
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 *  Date: 29 March 2022
 * */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity
public class Payments implements Serializable {
    @NotNull
    @Id
    private String paymentID;
    private String customerID;
    private String paymentType;
    private String amount;

    protected Payments(){}

    private Payments(Builder builder) {


        this.paymentID = builder.paymentID;
        this.customerID = builder.customerID;
        this.paymentType = builder.paymentType;
        this.amount = builder.amount;
    }
    public String getPaymentID() {
        return paymentID;}

    public String getPaymentType() {
        return paymentType;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getAmount() {
        return amount;
    }



    public static class Builder {
        private String paymentID;
        private String customerID;
        private String paymentType;
        private String amount;


        public Builder setPaymentID(String paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder setCustomerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder setPaymentType(String paymentType) {
            this.paymentType = paymentType;
            return this;
        }


        public Builder setAmount(String amount) {
            this.amount = amount;
            return this;
        }



        public Builder copy(Payments payments) {
            this.paymentID = payments.paymentID;
            this.customerID = payments.customerID;
            this.paymentType = payments.paymentType;
            this.amount = payments.amount;
            return this;
        }

        public Payments build() {
            return new Payments(this);
        }


        @Override
        public String toString() {
            return "Payments{" +
                    "paymentID=" + paymentID +
                    ", customerID=" + customerID +
                    ", paymentType=" + paymentType +
                    ", amount='" + amount + '\'' +
                    '}';
        }



    }
}

package za.ac.cput.domain;

import org.apache.maven.surefire.shade.org.apache.commons.lang3.builder.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Locale;
/* Tables.Java
 *  Entity for Tables
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 *  Date: 29 March 2022
 * */
@Entity
public class Tables implements Serializable {
    @NotNull
    @Id
    private String tableID;
    private String tableStatus;
    private String capacity;
    private String tableType;

    protected Tables(){}

    private Tables(Builder builder){

        this.tableID=builder.tableID;
        this.tableStatus=builder.tableStatus;
        this.capacity=builder.capacity;
        this.tableType=builder.tableType;

    }

    public String getTableID() {
        return tableID;
    }

    public String getTableStatus() {
        return tableStatus;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getTableType() {
        return tableType;
    }

    public static class Builder {
        private String tableID;
        private String tableStatus;
        private String capacity;
        public String tableType;

        public Builder setTableID(String tableID) {
            this.tableID = tableID;
            return this;
        }

        public Builder setTableStatus(String tableStatus) {
            this.tableStatus = tableStatus;
            return this;
        }

        public Builder setCapacity(String capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder setTableType(String tableType) {
            this.tableType = tableType;
            return this;
        }

        public Builder copy(Tables tables) {
            this.tableID = tables.tableID;
            this.tableStatus = tables.tableStatus;
            this.capacity = tables.capacity;
            this.tableType = tables.tableType;
            return this;
        }

        public Tables build() {
            return new Tables(this);
        }


        @Override
        public String toString() {
            return "Tables{" +
                    "tableID=" + tableID +
                    ", tableStatus='" + tableStatus + '\'' +
                    ", capacity=" + capacity +
                    ", tableType='" + tableType + '\'' +
                    '}';
        }





    }
}

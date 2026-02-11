package request;

import java.io.Serializable;

public class BloodRequest implements Serializable {
    private int id;
    private String customerName;
    private String bloodType;
    private int units;
    private String status;

    public BloodRequest(int id, String customerName, String bloodType, int units) {
        this.id = id;
        this.customerName = customerName;
        this.bloodType = bloodType;
        this.units = units;
        this.status = "Pending";
    }

    public int getId() { return id; }
    public String getCustomerName() { return customerName; }
    public String getBloodType() { return bloodType; }
    public int getUnits() { return units; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "ID: "+id+", Customer: "+customerName+", Blood Type: "+bloodType+", Units: "+units+", Status: "+status;
    }
}

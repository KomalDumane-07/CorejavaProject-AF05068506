package product;

import java.io.Serializable;

public class BloodProduct implements Serializable {
    private String type;
    private int units;

    public BloodProduct(String type, int units) {
        this.type = type;
        this.units = units;
    }

    public String getType() { return type; }
    public int getUnits() { return units; }
    public void setUnits(int units) { this.units = units; }

    @Override
    public String toString() {
        return "Type: " + type + ", Units: " + units;
    }
}

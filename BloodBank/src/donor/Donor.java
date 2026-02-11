package donor;

import java.io.Serializable;

public class Donor implements Serializable {
    private int id;
    private String name;
    private String bloodType;
    private int age;

    public Donor(int id, String name, String bloodType, int age) {
        this.id = id;
        this.name = name;
        this.bloodType = bloodType;
        this.age = age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getBloodType() { return bloodType; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setBloodType(String bloodType) { this.bloodType = bloodType; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Blood Type: " + bloodType + ", Age: " + age;
    }
}

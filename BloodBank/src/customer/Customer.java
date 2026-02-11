package customer;

import java.io.Serializable;

public class Customer implements Serializable {
    private int id;
    private String name;
    private String bloodType;
    private String username;
    private String password;

    public Customer(int id, String name, String bloodType, String username, String password){
        this.id=id; this.name=name; this.bloodType=bloodType; this.username=username; this.password=password;
    }

    public int getId(){ return id; }
    public String getName(){ return name; }
    public String getBloodType(){ return bloodType; }
    public String getUsername(){ return username; }
    public String getPassword(){ return password; }

    @Override
    public String toString(){ return "ID: "+id+", Name: "+name+", Blood Type: "+bloodType; }
}

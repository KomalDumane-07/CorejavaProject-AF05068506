package customer;

import donor.DonorOperations;
import product.Inventory;
import request.RequestOperations;
import utils.Database;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerOperations {
    private ArrayList<Customer> customers;
    private int nextId;

    public CustomerOperations(){
        customers = Database.loadCustomers();
        nextId = customers.size()+1;
        if(customers.isEmpty()) customers.add(new Customer(nextId++,"DemoCustomer","O+","user","123"));
    }

    public Customer login(Scanner sc){
        System.out.print("Enter username: "); String uname = sc.nextLine();
        System.out.print("Enter password: "); String pass = sc.nextLine();
        for(Customer c:customers) if(c.getUsername().equals(uname)&&c.getPassword().equals(pass)){
            System.out.println("Customer login successful!"); return c;
        }
        System.out.println("Invalid credentials!"); return null;
    }

    public boolean customerMenu(Scanner sc, DonorOperations donorOps, Inventory inventory, Customer customer){
        RequestOperations reqOps = new RequestOperations();
        System.out.println("\n--- Customer Menu ---");
        System.out.println("1. View Donors");
        System.out.println("2. View Inventory");
        System.out.println("3. Request Blood");
        System.out.println("4. Back/Logout");
        System.out.print("Enter choice: "); int choice = sc.nextInt(); sc.nextLine();

        switch(choice){
            case 1: donorOps.viewDonorsOnly(); break;
            case 2: inventory.viewStockOnly(); break;
            case 3: reqOps.makeRequest(sc,customer.getName(),inventory); break;
            case 4: System.out.println("Logging out..."); return true;
            default: System.out.println("Invalid choice!"); break;
        }
        return false;
    }

    public void customerMenu(Scanner sc){
        System.out.println("\n--- Customer Management ---");
        System.out.println("1. View Customers");
        System.out.println("2. Add Customer");
        System.out.println("3. Back");
        System.out.print("Enter choice: "); int choice = sc.nextInt(); sc.nextLine();
        switch(choice){
            case 1: System.out.println("\n--- Customer List ---"); for(Customer c:customers) System.out.println(c); break;
            case 2:
                System.out.print("Name: "); String name = sc.nextLine();
                System.out.print("Blood Type: "); String type = sc.nextLine();
                System.out.print("Username: "); String uname = sc.nextLine();
                System.out.print("Password: "); String pass = sc.nextLine();
                customers.add(new Customer(nextId++,name,type,uname,pass));
                System.out.println("Customer added!");
                break;
            case 3: break;
            default: System.out.println("Invalid choice!"); break;
        }
        Database.saveCustomers(customers);
    }
}

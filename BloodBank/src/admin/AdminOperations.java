package admin;

import donor.DonorOperations;
import customer.CustomerOperations;
import product.Inventory;
import request.RequestOperations;

import java.util.Scanner;

public class AdminOperations {
    private final String username = "admin";
    private final String password = "123";

    public boolean login(Scanner sc){
        System.out.print("Enter Admin username: "); String u = sc.nextLine();
        System.out.print("Enter password: "); String p = sc.nextLine();
        if(u.equals(username) && p.equals(password)){
            System.out.println("Admin login successful!");
            return true;
        } else { System.out.println("Invalid credentials!"); return false;}
    }

    public void adminMenu(Scanner sc, DonorOperations donorOps, CustomerOperations customerOps, Inventory inventory){
        RequestOperations reqOps = new RequestOperations();
        boolean exit=false;
        while(!exit){
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Manage Donors");
            System.out.println("2. Manage Customers");
            System.out.println("3. Manage Inventory");
            System.out.println("4. Manage Admins (Not implemented)");
            System.out.println("5. Donation Report");
            System.out.println("6. Logout");
            System.out.print("Enter choice: "); int choice=sc.nextInt(); sc.nextLine();
            switch(choice){
                case 1: donorOps.donorMenu(sc); break;
                case 2: customerOps.customerMenu(sc); break;
                case 3: inventory.inventoryMenu(sc); break;
                case 4: System.out.println("Admin management not implemented"); break;
                case 5: reqOps.donationReport(); break;
                case 6: exit=true; System.out.println("Logging out..."); break;
                default: System.out.println("Invalid choice!"); break;
            }
        }
    }
}

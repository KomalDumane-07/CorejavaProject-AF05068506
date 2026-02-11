import admin.AdminOperations;
import customer.CustomerOperations;
import donor.DonorOperations;
import product.Inventory;
import customer.Customer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        AdminOperations adminOps = new AdminOperations();
        CustomerOperations customerOps = new CustomerOperations();
        Inventory inventory = new Inventory();
        DonorOperations donorOps = new DonorOperations();

        boolean exit=false;
        while(!exit){
            System.out.println("\n=== Blood Bank System ===");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: "); int choice=sc.nextInt(); sc.nextLine();
            switch(choice){
                case 1:
                    if(adminOps.login(sc)) adminOps.adminMenu(sc, donorOps, customerOps, inventory);
                    break;
                case 2:
                    Customer c = customerOps.login(sc);
                    if(c!=null){
                        boolean logout=false;
                        while(!logout) logout = customerOps.customerMenu(sc, donorOps, inventory, c);
                    }
                    break;
                case 3: exit=true; System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!"); break;
            }
        }
    }
}

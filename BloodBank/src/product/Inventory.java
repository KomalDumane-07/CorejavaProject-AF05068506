package product;

import utils.Database;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory implements Serializable {
    private ArrayList<BloodProduct> products;

    public Inventory() {
        products = Database.loadInventory();
        if(products.isEmpty()) {
            String[] types = {"A+","A-","B+","B-","AB+","AB-","O+","O-"};
            for(String t : types) products.add(new BloodProduct(t,0));
        }
    }

    public void inventoryMenu(Scanner sc) {
        System.out.println("\n--- Inventory Management ---");
        System.out.println("1. View Stock");
        System.out.println("2. Add Stock");
        System.out.println("3. Remove Stock");
        System.out.println("4. Back");
        System.out.print("Enter choice: "); int choice = sc.nextInt(); sc.nextLine();

        switch(choice){
            case 1: viewStockOnly(); break;
            case 2: addStockMenu(sc); break;
            case 3: removeStockMenu(sc); break;
            case 4: break;
            default: System.out.println("Invalid choice!");
        }
        Database.saveInventory(products);
    }

    public void viewStockOnly() {
        System.out.println("\n--- Blood Stock ---");
        for(BloodProduct p : products) System.out.println(p);
    }

    public boolean reduceStock(String type, int units){
        for(BloodProduct p : products){
            if(p.getType().equalsIgnoreCase(type)){
                if(p.getUnits() >= units){
                    p.setUnits(p.getUnits()-units);
                    Database.saveInventory(products);
                    return true;
                } else return false;
            }
        }
        return false;
    }

    public void addStock(String type, int units){
        for(BloodProduct p : products){
            if(p.getType().equalsIgnoreCase(type)){
                p.setUnits(p.getUnits()+units);
                Database.saveInventory(products);
                return;
            }
        }
    }

    private void addStockMenu(Scanner sc){
        System.out.print("Enter Blood Type to add: "); String type=sc.nextLine();
        System.out.print("Enter Units to add: "); int units=sc.nextInt(); sc.nextLine();
        addStock(type,units);
        System.out.println("Stock added!");
    }

    private void removeStockMenu(Scanner sc){
        System.out.print("Enter Blood Type to remove: "); String type=sc.nextLine();
        System.out.print("Enter Units to remove: "); int units=sc.nextInt(); sc.nextLine();
        if(reduceStock(type,units)) System.out.println("Stock removed!");
        else System.out.println("Not enough stock to remove!");
    }
}

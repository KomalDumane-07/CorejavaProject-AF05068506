package request;

import utils.Database;
import product.Inventory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class RequestOperations implements Serializable {
    private ArrayList<BloodRequest> requests;
    private int nextId;

    public RequestOperations() {
        requests = Database.loadRequests();
        nextId = requests.size()+1;
    }

    public void makeRequest(Scanner sc, String customerName, Inventory inventory){
        System.out.print("Enter Blood Type: "); String type = sc.nextLine();
        System.out.print("Enter Units: "); int units = sc.nextInt(); sc.nextLine();

        if(inventory.reduceStock(type, units)){
            BloodRequest r = new BloodRequest(nextId++, customerName, type, units);
            r.setStatus("Approved");
            requests.add(r);
            Database.saveRequests(requests);
            System.out.println("Request approved and stock updated!");
        } else System.out.println("Not enough stock for requested blood!");
    }

    public void viewRequests(){
        System.out.println("\n--- All Blood Requests ---");
        if(requests.isEmpty()) System.out.println("No requests yet!");
        else for(BloodRequest r : requests) System.out.println(r);
    }

    public void donationReport(){
        System.out.println("\n--- Donation Report ---");
        if(requests.isEmpty()) System.out.println("No donations yet!");
        else {
            int[] count = new int[8];
            String[] types = {"A+","A-","B+","B-","AB+","AB-","O+","O-"};
            for(BloodRequest r : requests){
                for(int i=0;i<types.length;i++){
                    if(r.getBloodType().equalsIgnoreCase(types[i])) count[i]+=r.getUnits();
                }
            }
            for(int i=0;i<types.length;i++) System.out.println(types[i]+": "+count[i]+" units donated");
        }
    }
}

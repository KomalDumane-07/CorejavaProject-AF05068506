package donor;

import utils.Database;
import java.util.ArrayList;
import java.util.Scanner;

public class DonorOperations {
    private ArrayList<Donor> donors;
    private int nextId;

    public DonorOperations() {
        donors = Database.loadDonors();
        nextId = donors.size() + 1;
    }

    public void donorMenu(Scanner sc) {
        System.out.println("\n--- Donor Management ---");
        System.out.println("1. Add Donor");
        System.out.println("2. View Donors");
        System.out.println("3. Update Donor");
        System.out.println("4. Delete Donor");
        System.out.println("5. Search Donor by Blood Type");
        System.out.println("6. Back");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt(); sc.nextLine();

        switch (choice) {
            case 1: addDonor(sc); break;
            case 2: viewDonors(); break;
            case 3: updateDonor(sc); break;
            case 4: deleteDonor(sc); break;
            case 5: searchByBloodType(sc); break;
            case 6: break;
            default: System.out.println("Invalid choice!");
        }
        Database.saveDonors(donors);
    }

    private void addDonor(Scanner sc) {
        System.out.print("Enter Name: "); String name = sc.nextLine();
        System.out.print("Enter Blood Type: "); String type = sc.nextLine();
        System.out.print("Enter Age: "); int age = sc.nextInt(); sc.nextLine();
        donors.add(new Donor(nextId++, name, type, age));
        System.out.println("Donor added successfully!");
    }

    public void viewDonors() {
        System.out.println("\n--- Donor List ---");
        if(donors.isEmpty()) System.out.println("No donors yet!");
        else for(Donor d : donors) System.out.println(d);
    }

    public void viewDonorsOnly() {
        viewDonors();
    }

    private void updateDonor(Scanner sc) {
        System.out.print("Enter Donor ID to update: "); int id = sc.nextInt(); sc.nextLine();
        for(Donor d : donors) {
            if(d.getId() == id) {
                System.out.print("New Name: "); d.setName(sc.nextLine());
                System.out.print("New Blood Type: "); d.setBloodType(sc.nextLine());
                System.out.print("New Age: "); d.setAge(sc.nextInt()); sc.nextLine();
                System.out.println("Donor updated!");
                return;
            }
        }
        System.out.println("Donor not found!");
    }

    private void deleteDonor(Scanner sc) {
        System.out.print("Enter Donor ID to delete: "); int id = sc.nextInt(); sc.nextLine();
        donors.removeIf(d -> d.getId() == id);
        System.out.println("Donor deleted if existed!");
    }

    private void searchByBloodType(Scanner sc) {
        System.out.print("Enter Blood Type to search: "); String type = sc.nextLine();
        boolean found = false;
        for(Donor d : donors) {
            if(d.getBloodType().equalsIgnoreCase(type)) {
                System.out.println(d);
                found = true;
            }
        }
        if(!found) System.out.println("No donors found for blood type " + type);
    }
}

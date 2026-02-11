package utils;

import donor.Donor;
import customer.Customer;
import product.BloodProduct;
import request.BloodRequest;

import java.io.*;
import java.util.ArrayList;

public class Database {

    public static void saveDonors(ArrayList<Donor> donors) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("donors.dat"))) {
            oos.writeObject(donors);
        } catch (Exception e) { System.out.println(e.getMessage()); }
    }

    public static ArrayList<Donor> loadDonors() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("donors.dat"))) {
            return (ArrayList<Donor>) ois.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }

    public static void saveCustomers(ArrayList<Customer> customers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("customers.dat"))) {
            oos.writeObject(customers);
        } catch (Exception e) { System.out.println(e.getMessage()); }
    }

    public static ArrayList<Customer> loadCustomers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("customers.dat"))) {
            return (ArrayList<Customer>) ois.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }

    public static void saveInventory(ArrayList<BloodProduct> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("inventory.dat"))) {
            oos.writeObject(products);
        } catch (Exception e) { System.out.println(e.getMessage()); }
    }

    public static ArrayList<BloodProduct> loadInventory() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("inventory.dat"))) {
            return (ArrayList<BloodProduct>) ois.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }

    public static void saveRequests(ArrayList<BloodRequest> requests) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("requests.dat"))) {
            oos.writeObject(requests);
        } catch (Exception e) { System.out.println(e.getMessage()); }
    }

    public static ArrayList<BloodRequest> loadRequests() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("requests.dat"))) {
            return (ArrayList<BloodRequest>) ois.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }
}

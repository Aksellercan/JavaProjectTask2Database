package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    Scanner sc = new Scanner(System.in);
    Databaseactions db = new Databaseactions();
    private ArrayList<Smartphone> smartphonelist = new ArrayList<>(); //Global collection of only smartphone type

    public ArrayList<Smartphone> getSmartphonelist() {
        return smartphonelist;
    }

    public void setSmartphonelist(ArrayList<Smartphone> smartphonelist) {
        //this.smartphonelist = new ArrayList<>(smartphonelist);
        this.smartphonelist = smartphonelist;
    }
    // add phone questioniare
    public void addphones() {

        System.out.print("Name: ");
        String name = sc.next();

        System.out.print("RAM (GB): ");
        int ram = sc.nextInt();

        System.out.print("Processor Speed (GHz): ");
        double processorSpeed = sc.nextDouble();

        System.out.print("Battery Size (mAh): ");
        int batterySize = sc.nextInt();

        System.out.print("Screen Size (inches): ");
        double screenSize = sc.nextDouble();

        System.out.print("Storage (GB): ");
        int storage = sc.nextInt();

        System.out.println("Select Operating System:" + "\n1. Android" + "\n2. IOS");
        int oschoice = sc.nextInt();
        OperatingSystem os = db.getOperatingSystemById(oschoice-1); // convert

        Smartphone phone = new Smartphone(name, ram, processorSpeed, batterySize, screenSize, storage, os);

        db.SaveData(phone);
        smartphonelist.add(phone);
        System.out.println("Phone added successfully!");
    }

    public void RemovePhones() {
        System.out.println("enter id of the phone you would like to remove: ");
        int choice = sc.nextInt();
        Smartphone phoneremove = smartphonelist.get(choice - 1);
        System.out.println(phoneremove.getName() + " is removed");
        db.removeData(phoneremove);
    }

    public void getphone() {
        System.out.println("Enter the phone ID you want to view:");
        int id = sc.nextInt();
        System.out.println(smartphonelist.get(id - 1));
        String wait = sc.nextLine();
    }
    //edit phone questionaire
    public void editPhone() {
        System.out.println("Enter ID of the phone you would like to edit: ");
        int choice = sc.nextInt();
        Smartphone editphone = smartphonelist.get(choice - 1);
        while (true) {
            System.out.println("Editing " + editphone.getName() + ":");
            System.out.println("Which attribute would you like to edit?" + "\n1. Name"+ "\n2. RAM" + "\n3. Processor Speed" + "\n4. Battery Size");
            System.out.println("5. Screen Size" + "\n6. Storage Size" + "\n7. Operating System" + "\n0. Cancel" + "\nEnter your choice: ");
            int editChoice = sc.nextInt();

            switch (editChoice) {
                case 1: // Edit Name
                    System.out.print("Enter new name (current: " + editphone.getName() + "): ");
                    String newName = sc.next();
                    editphone.setName(newName);
                    break;

                case 2: // Edit RAM
                    System.out.print("Enter new RAM (current: " + editphone.getRam() + "): ");
                    int newRam = sc.nextInt();
                    editphone.setRam(newRam);
                    break;

                case 3: // Edit Processor Speed
                    System.out.print("Enter new processor speed (current: " + editphone.getProcessorspeed() + "): ");
                    double newProcessorSpeed = sc.nextDouble();
                    editphone.setProcessorspeed(newProcessorSpeed);
                    break;

                case 4: // Edit Battery Size
                    System.out.print("Enter new battery size (current: " + editphone.getBatterysize() + "): ");
                    int newBatterySize = sc.nextInt();
                    editphone.setBatterysize(newBatterySize);
                    break;

                case 5: // Edit Screen Size
                    System.out.print("Enter new screen size (current: " + editphone.getScreensize() + "): ");
                    double newScreenSize = sc.nextDouble();
                    editphone.setScreensize(newScreenSize);
                    break;

                case 6: // Edit Storage
                    System.out.print("Enter new storage (current: " + editphone.getStorage() + "): ");
                    int newStorage = sc.nextInt();
                    editphone.setStorage(newStorage);
                    break;

                case 7: // Edit Operating System
                    System.out.print("Enter the new Operating System ID (1 for Android, 2 for iOS): ");
                    int osChoice = sc.nextInt();
                    OperatingSystem newOS = db.getOperatingSystemById(osChoice-1);
                    editphone.setOperatingSystem(newOS);
                    break;

                case 0: // Cancel
                    System.out.println("Editing canceled.");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue; // Restart the loop if invalid input
            }
            db.updateData(editphone);
            System.out.println("Successfully updated " + editphone.getName() + " values");

        }
    }

    public void fetchPhonesfromDatabase() {
        smartphonelist = db.FetchData();
    }
    //sort by os ui
    public void sortbyOS() {
        System.out.println("Enter the OS number you want to sort by: " + "\n1 for Android\n2 for iOS");
        int os = sc.nextInt();
        String choice = "";
        while (true) {
            if (os == 1) {
                choice = "android";
                db.listPhonesByOS(choice);
                break;
            } else if (os == 2) {
                choice = "iOS";
                db.listPhonesByOS(choice);
                break;
            }
            System.out.println("Invalid choice");
            System.out.println("Enter the OS number you want to sort by: " + "\n1 for Android\n2 for iOS");
            os = sc.nextInt();
        }
    }
    // list all available phones
    public void listphones() {
        for (int i = 0; i < smartphonelist.size(); i++) {
            System.out.println((i + 1) + ": " + smartphonelist.get(i).toString());
        }
    }
}

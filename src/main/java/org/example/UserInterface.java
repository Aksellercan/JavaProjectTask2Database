package org.example;

import java.util.Scanner;

// inheritance from Inventory class
public class UserInterface extends Inventory {

    private void userInterface() {
        fetchPhonesfromDatabase();
        listphones();
        System.out.println("\n" + "1 to get phone");
        System.out.println("2 to add phones");
        System.out.println("3 to compare phones");
        System.out.println("4 to delete phones");
        System.out.println("5 to import from file");
        System.out.println("6 to save to file");
        System.out.println("7 to sort by Operating System");
        System.out.println("8 to edit phone values");
        System.out.println("0 to exit");
    }
    //Full CRUD Options
    public void run() {
        while (true) {
            System.out.println("User Interface");
            userInterface();
            Scanner scs = new Scanner(System.in);
            int choice = scs.nextInt();
            switch (choice) {
                case 1:
                    getphone();
                    break;
                case 2:
                    addphones();
                    break;
                case 3:
                    Comparison comparison = new Comparison();
                    comparison.compareUI(comparison.Phonestocompare(getSmartphonelist())); // pass global arraylist to Comparison class
                    break;
                case 4:
                    RemovePhones();
                    break;
                case 5:
                    FileUtil fileload = new FileUtil();
                    fileload.readfromfile();
                    break;
                case 6:
                    FileUtil fileUtilsave = new FileUtil();
                    fileUtilsave.addtofile(getSmartphonelist());
                    break;
                case 7:
                    sortbyOS();
                    break;
                case 8:
                    editPhone();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}

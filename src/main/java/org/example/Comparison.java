package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Comparison {
    Scanner sc = new Scanner(System.in);

    // Get 2 objects from global arraylist and return 2 objects user chooses
    public Smartphone[] Phonestocompare(ArrayList<Smartphone> phones) {
        System.out.println("Enter Phone Number");
        int p = sc.nextInt();
        int ptr = p - 1;
        Smartphone first = phones.get(ptr);
        System.out.println(phones.get(ptr).getName() + " and Enter Phone Number 2");
        int q = sc.nextInt();
        int qtr = q - 1;
        Smartphone second = phones.get(qtr);
        System.out.println(phones.get(qtr).getName() + " and " + phones.get(ptr).getName());

        return new Smartphone[]{first, second};
    }
    // compare
    public void Compare(double firstvalue, double secondvalue, String firstname, String secondname, String attribute) {
        String wait = "";

        if (firstvalue > secondvalue) {
            System.out.println(firstname + " has more " + attribute + " than " + secondname);
            wait = sc.nextLine();
        } else if (firstvalue < secondvalue) {
            System.out.println(secondname + " has more " + attribute + " than " + firstname);
            wait = sc.nextLine();
        } else {
            System.out.println("Both phones are equal.");
            wait = sc.nextLine();
        }
    }

    public void Comparesidebyside(Smartphone[] phones) {
        for (int i = 0; i < phones.length; i++) {
            System.out.println((i + 1) + ": " + phones[i].toString());
        }
        String wait = sc.nextLine();
    }
    //get 2 objects from PhonestoCompare
    public void compareUI(Smartphone[] phones) {
        Smartphone first = phones[0];
        Smartphone second = phones[1];

        while (true) {
            System.out.println("Choose an attribute to compare:");
            System.out.println("1. RAM");
            System.out.println("2. Battery Size");
            System.out.println("3. Screen Size");
            System.out.println("4. Storage");
            System.out.println("5. Processor Speed");
            System.out.println("6. Side by Side Comparison");
            System.out.println("0. Exit");
            String attribute = "";
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    attribute = "RAM";
                    Compare(first.getRam(), second.getRam(), first.getName(), second.getName(), attribute);
                    break;
                case 2:
                    attribute = "battery";
                    Compare(first.getBatterysize(), second.getBatterysize(), first.getName(), second.getName(), attribute);
                    break;
                case 3:
                    attribute = "screen";
                    Compare(first.getScreensize(), second.getScreensize(), first.getName(), second.getName(), attribute);
                    break;
                case 4:
                    attribute = "storage";
                    Compare(first.getStorage(), second.getStorage(), first.getName(), second.getName(), attribute);
                    break;
                case 5:
                    attribute = "processor power";
                    Compare(first.getProcessorspeed(), second.getProcessorspeed(), first.getName(), second.getName(), attribute);
                    break;
                case 6:
                    Comparesidebyside(phones);
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

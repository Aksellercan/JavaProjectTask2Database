package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

    class FileUtil {
        private String filepath ="src\\main\\java\\org\\example\\phoneslistdatabase.txt";

        //saves from database to txt file
        public void addtofile(ArrayList<Smartphone> phones) {
            try(FileWriter mywriter = new FileWriter(filepath,false)) {
                for (Smartphone phone : phones) {
                    mywriter.write(formatPhoneForFile(phone) + "\n");
                }
                System.out.println("Saved to file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        // readfromfile imports the txt file to database
        public void readfromfile() {

            try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
                String line;
                Databaseactions db = new Databaseactions();
                db.clearSmartphoneTable(); //clear database to avoid duplicates
                while((line = br.readLine()) != null) {
                    Smartphone phone = parsePhoneFromLine(line);
                    if (phone != null ) {
                        db.SaveData(phone);
                    }
                }
                System.out.println("Successfully loaded from file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        // formating and parse
        /// ///
        private Smartphone parsePhoneFromLine(String line) {
            try {
                String[] values = line.split(",");
                if (values.length == 7) {
                    String name = values[0];
                    int ram = Integer.parseInt(values[1]);
                    int batterySize = Integer.parseInt(values[2]);
                    double screenSize = Double.parseDouble(values[3]);
                    double processorSpeed = Double.parseDouble(values[4]);
                    int storage = Integer.parseInt(values[5]);
                    //int os_id = Integer.parseInt(values[6]);
                    String osName = values[6].trim();

                    int os_id = -1;
                    if (osName.equalsIgnoreCase("iOS")) {
                        os_id = 1;
                    } else if (osName.equalsIgnoreCase("android")) {
                        os_id = 0;
                    }

                    Databaseactions db = new Databaseactions();
                    OperatingSystem os = db.getOperatingSystemById(os_id);


                    if (os == null) {
                        System.out.println("Operating system with ID " + os_id + " not found.");
                        return null;  // Skip this phone if OS is not found
                    }
                    return new Smartphone(name,ram,processorSpeed, batterySize, screenSize, storage,os);
                }
            } catch (Exception e) {
                System.out.println("Error parsing phone from line: " + line);
            }
            return null;
        }
        /// ///
        private String formatPhoneForFile(Smartphone phone) {
            return phone.getName() + "," +
                    phone.getRam() + "," +
                    phone.getBatterysize() + "," +
                    phone.getScreensize() + "," +
                    phone.getProcessorspeed() + "," +
                    phone.getStorage() + "," +
                    phone.getOperatingSystem();
        }
    }
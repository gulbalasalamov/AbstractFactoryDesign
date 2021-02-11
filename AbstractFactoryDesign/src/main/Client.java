package main;


import abstractfactory.FactoryProvider;
import interfaces.AbstractFactory;
import model.*;
import products.AndroidPhone;
import products.IPhone;
import products.PC;
import products.Server;
import util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {

    private static SmartPhone refPhone = new AndroidPhone(new SmartPhoneSpec(Type.TEST, Manufacturer.TEST, "z", 0, false, false, false), 0);
    private static Computer refComp = new PC(new ComputerSpec(Type.TEST, Manufacturer.TEST, "z", 0, 0, false), 0);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        initializeInventory();
        executeAbstractFactory(addProduct(new Scanner(System.in)));

        ComputerSpec computerYouLike = createOrderComp(scanner);
        searchComputers(refComp, computerYouLike);
        searchComputerById(refComp, scanner);

        Scanner scanner1 = new Scanner(System.in);
        SmartPhoneSpec smartphoneYouLike = createOrderSmartPhone(scanner1);
        searchSmartPhones(refPhone, smartphoneYouLike);
        searchSmartPhoneById(refPhone, scanner);
    }

    private static void executeAbstractFactory(List<Object> objectList) {

        if (!objectList.isEmpty()) {
            Choice choice = objectList.get(0) instanceof String ?
                    Choice.valueOf(((String) objectList.get(0)).toUpperCase()) : null;

            Type type = objectList.get(1) instanceof String ?
                    Type.valueOf(((String) objectList.get(1)).toUpperCase()) : null;

            Manufacturer manufacturer = objectList.get(2) instanceof String ?
                    Manufacturer.valueOf(((String) objectList.get(2)).toUpperCase()) : null;

            String model = objectList.get(3) instanceof String ?
                    (String) objectList.get(3) : null;

            int ram = 0;
            int releaseYear = 0;
            int monitor = 0;
            boolean coolingSystem = false;
            boolean NFC = false;
            boolean fastCharge = false;
            boolean touchScreen = false;
            double price = 0.0;

            if (type.toString().equalsIgnoreCase("server") || type.toString().equalsIgnoreCase("pc")) {
                ram = (int) objectList.get(4);
                monitor = (int) objectList.get(5);
                coolingSystem = (boolean) objectList.get(6);
                price = (double) objectList.get(7);
            } else if (type.toString().equalsIgnoreCase("android") || type.toString().equalsIgnoreCase("iphone")) {
                releaseYear = (int) objectList.get(4);
                NFC = (boolean) objectList.get(5);
                touchScreen = (boolean) objectList.get(6);
                fastCharge = (boolean) objectList.get(7);
                price = (double) objectList.get(8);
            }

            AbstractFactory abstractFactory;

            if (choice.toString().equalsIgnoreCase(Choice.COMPUTER.toString())) {
                abstractFactory = FactoryProvider.getFactory("computer");
                //ComputerFactory cf = (ComputerFactory) abstractFactory;

                if (type.toString().equalsIgnoreCase(Type.SERVER.toString())) {
                    Server server = (Server) abstractFactory.createComputer("Server", new ComputerSpec(type, manufacturer, model, ram, 0, coolingSystem), price);

                } else if (type.toString().equalsIgnoreCase(Type.PC.toString())) {
                    PC pc = (PC) abstractFactory.createComputer("Pc", new ComputerSpec(type, manufacturer, model, ram, monitor, false), price);
                }
            } else if (choice.toString().equalsIgnoreCase(Choice.SMARTPHONE.toString())) {
                abstractFactory = FactoryProvider.getFactory("smartphone");
                if (type.toString().equalsIgnoreCase(Type.ANDROID.toString())) {
                    AndroidPhone androidPhone = (AndroidPhone) abstractFactory.createSmartPhone("android", new SmartPhoneSpec(type, manufacturer, model, releaseYear, NFC, touchScreen, fastCharge), price);
                }
                if (type.toString().equalsIgnoreCase(Type.IPHONE.toString())) {
                    IPhone iPhone = (IPhone) abstractFactory.createSmartPhone("iphone", new SmartPhoneSpec(type, manufacturer, model, releaseYear, NFC, touchScreen, fastCharge), price);
                }
            }
            System.out.println("Thank you. You have just added a product to inventory.\n");
        }
    }

    private static List<Object> addProduct(Scanner scanner) {
        String choice;
        String manufacturer;
        String type;
        String model;
        int ram;
        boolean coolingSystem;
        boolean NFC;
        boolean touchScreen;
        boolean fastCharge;
        int releaseYear;
        int monitor;
        double price;
        List<Object> order = new ArrayList<Object>();
        System.out.println(Constants.CHOICE);
        choice = scanner.nextLine();
        order.add(choice);

        if (choice.equalsIgnoreCase(Choice.COMPUTER.toString())) {

            System.out.println(Constants.TYPE_COMPUTER);
            type = scanner.nextLine().toLowerCase();
            order.add(type);

            if (type.equalsIgnoreCase(Type.PC.toString()) || type.equalsIgnoreCase(Type.SERVER.toString())) {

                System.out.println(Constants.MANUFACTURERS);
                manufacturer = scanner.nextLine().toLowerCase();
                order.add(manufacturer);

                System.out.println(Constants.MODEL);
                model = scanner.nextLine().toLowerCase();
                order.add(model);

                System.out.println(Constants.RAM_SIZE);
                ram = scanner.nextInt();
                order.add(ram);

                System.out.println(Constants.NUMBER_OF_MONITOR);
                monitor = scanner.nextInt();
                order.add(monitor);

                System.out.println(Constants.COOLING_SYSTEM);
                //coolingSystem = scanner.nextBoolean();
                coolingSystem = scanner.nextLine().equalsIgnoreCase("Yes") ||
                        scanner.nextLine().equalsIgnoreCase("No");
                order.add(coolingSystem);

                System.out.println(Constants.PRICE);
                price = scanner.nextDouble();
                order.add(price);

            }

        } else if (choice.equalsIgnoreCase(Choice.SMARTPHONE.toString())) {

            System.out.println(Constants.TYPE_SMARTPHONE);
            type = scanner.nextLine().toLowerCase();
            order.add(type);

            if (type.equalsIgnoreCase(Type.ANDROID.toString()) || type.equalsIgnoreCase(Type.IPHONE.toString())) {

                System.out.println(Constants.MANUFACTURERS);
                manufacturer = scanner.nextLine().toLowerCase();
                order.add(manufacturer);

                System.out.println(Constants.MODEL);
                model = scanner.nextLine().toLowerCase();
                order.add(model);

                System.out.println(Constants.RELEASE_YEAR);
                releaseYear = scanner.nextInt();
                order.add(releaseYear);

                System.out.println(Constants.NFC_FEATURE);
                NFC = scanner.nextLine().equalsIgnoreCase("Yes") ||
                        scanner.nextLine().equalsIgnoreCase("No");
                order.add(NFC);

                System.out.println(Constants.TOUCHSCREEN);
                touchScreen = scanner.nextLine().equalsIgnoreCase("Yes") ||
                        scanner.nextLine().equalsIgnoreCase("No");
                order.add(touchScreen);

                System.out.println(Constants.FAST_CHARGE_FEATURE);
                fastCharge = scanner.nextLine().equalsIgnoreCase("Yes") ||
                        scanner.nextLine().equalsIgnoreCase("No");
                order.add(fastCharge);

                System.out.println(Constants.PRICE);
                price = scanner.nextDouble();
                order.add(price);
            }
        }
        return order;
    }

    private static void initializeInventory() {

        System.out.println("Creating the initial inventory...\nAdded: \n7 PC,\n3 Server,\n4 Android,\nand 1 iPhone.\n\nPlease add a new item to the inventory ");
        Computer pc1 = new PC(new ComputerSpec(Type.PC, Manufacturer.HP, "HP 15 RT216", 8, 1, false), 700);
        Computer pc2 = new PC(new ComputerSpec(Type.PC, Manufacturer.LENOVO, "T450", 8, 1, false), 900);
        Computer pc3 = new PC(new ComputerSpec(Type.PC, Manufacturer.ASUS, "T450", 8, 1, false), 300);
        Computer pc4 = new PC(new ComputerSpec(Type.PC, Manufacturer.HP, "Dv6", 4, 1, false), 750);
        Computer pc5 = new PC(new ComputerSpec(Type.PC, Manufacturer.LENOVO, "x23", 8, 1, false), 900);
        Computer pc6 = new PC(new ComputerSpec(Type.PC, Manufacturer.FUJITSU, "x23", 12, 1, false), 1100);
        Computer serverDell = new Server(new ComputerSpec(Type.SERVER, Manufacturer.DELL, "R720", 128, 0, true), 18000);
        Computer serverDell2 = new Server(new ComputerSpec(Type.SERVER, Manufacturer.DELL, "R430", 64, 0, true), 14500);
        Computer serverDell3 = new Server(new ComputerSpec(Type.SERVER, Manufacturer.DELL, "R200", 32, 0, true), 11000);

        SmartPhone androidSamsung = new AndroidPhone(new SmartPhoneSpec(Type.ANDROID, Manufacturer.SAMSUNG, "A97", 2019, true, true, true), 320);
        SmartPhone androidXiaomi1 = new AndroidPhone(new SmartPhoneSpec(Type.ANDROID, Manufacturer.SAMSUNG, "A70", 2019, true, true, true), 120);
        SmartPhone androidXiaomi2 = new AndroidPhone(new SmartPhoneSpec(Type.ANDROID, Manufacturer.LG, "G3", 2018, false, true, true), 240);
        SmartPhone iphone = new IPhone(new SmartPhoneSpec(Type.IPHONE, Manufacturer.APPLE, "iPhone 11", 2019, true, true, true), 1000);
    }

    private static ComputerSpec createOrderComp(Scanner scanner) {
        System.out.println("\nPlease specify computer specs to display from list: \nType:\n->PC?\n->Server?");
        Type type = Type.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Enter ram: ");
        int ram = scanner.nextInt();
        return new ComputerSpec(type, Manufacturer.LENOVO, "x", ram, 0, false);
    }

    private static SmartPhoneSpec createOrderSmartPhone(Scanner scanner) {
        System.out.println("Please specify smartphone specs to display from list: \nType:\n->Android?\n->iPhone?");
        Type type = Type.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Specify manufacturer: ");
        Manufacturer manufacturer = Manufacturer.valueOf(scanner.nextLine().toUpperCase());
        return new SmartPhoneSpec(type, manufacturer, "x", 0, false, false, false);
    }

    private static void searchSmartPhoneById(SmartPhone refPhone, Scanner scanner) {
        System.out.println("Enter id of smartphone to be displayed");
        int id = scanner.nextInt();
        SmartPhone smartPhone = refPhone.getSmartPhone(id);
        System.out.println(smartPhone);
    }

    private static void searchComputerById(Computer refComp, Scanner scanner) {
        System.out.println("Enter id of computer to be displayed");
        int id = scanner.nextInt();
        Computer computer = refComp.getComputer(id);
        System.out.println(computer);
    }

    private static void searchSmartPhones(SmartPhone refPhone, SmartPhoneSpec smartPhoneYouLike) {
        List<SmartPhone> matchedSmartPhones = refPhone.searchPhones(smartPhoneYouLike);
        if (!matchedSmartPhones.isEmpty()) {
            System.out.println("We have got these phones for you: ");
            for (SmartPhone s : matchedSmartPhones) {
                SmartPhoneSpec smartPhoneSpec = s.getSmartPhoneSpec();
                System.out.println("Type: " + smartPhoneSpec.getType() + ", " +
                        "Manufacturer: " + smartPhoneSpec.getManufacturer() + ", " +
                        "Model: " + smartPhoneSpec.getModel() + ", " +
                        "Release year: " + smartPhoneSpec.getReleaseYear() + ", " +
                        "NFC: " + smartPhoneSpec.hasNFC() + ", " +
                        "Touchscreen: " + smartPhoneSpec.hasTouchScreen() + ", " +
                        "Fast charge: " + smartPhoneSpec.hasFastCharge() + ", " +
                        "Price: " + s.getPrice());
            }
        } else {
            System.out.println("Sorry, we have nothing for you.");
        }
    }

    private static void searchComputers(Computer refComp, ComputerSpec computerYouLike) {
        List<Computer> matchedComputers = refComp.searchComputers(computerYouLike);

        if (!matchedComputers.isEmpty()) {
            System.out.println("We have got these computer(s) for you: ");
            for (Computer c : matchedComputers) {
                ComputerSpec cs = c.getComputerSpec();
                System.out.println("Type: " + cs.getType() + ", " +
                        "Manufacturer: " + cs.getManufacturer() + ", " +
                        "Model: " + cs.getModel() + ", " +
                        "Ram: " + cs.getRam() + ", " +
                        "Monitor: " + cs.getMonitor() + ", " +
                        "Cooling system: " + cs.hasCoolingSystem() + ", " +
                        "Price: " + c.getPrice());
            }
        } else {
            System.out.println("Sorry, we have nothing for you.");
        }
    }
}




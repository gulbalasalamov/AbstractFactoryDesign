package model;

import java.util.ArrayList;
import java.util.List;

public abstract class SmartPhone {
    private static int count = 0;
    private int serialNumber; //unique to each SmartPhone
    private double price; //unique to each SmartPhone
    SmartPhoneSpec smartPhoneSpec;
    static List<SmartPhone> inventory = new ArrayList<>();

    /**
     * Constructor for concrete classes PC and Server
     * Initializes Android and iPhone objects with given parameters and adds it to the computer inventory
     * @param smartPhoneSpec
     * @param price
     */
    public SmartPhone(SmartPhoneSpec smartPhoneSpec, double price) {
        this.serialNumber = ++count;
        this.price = price;
        this.smartPhoneSpec = smartPhoneSpec;
        inventory.add(this);
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public List getInventory() {
        return inventory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String message();

    /**
     * Returns the specific smartphone if the specified id matches with computer in the inventory
     *
     * @param id
     * @return
     */
    public SmartPhone getSmartPhone(int id) {
        for (SmartPhone smartPhone : inventory) {
            if (smartPhone.getSerialNumber() == id) {
                return smartPhone;
            }
        }
        return null;
    }

    /**
     * Returns list of smartphone object(s)
     * Loop through the list.
     * If the instance variable matches, it is added to return list
     *
     * @param searchSpec
     * @return
     */
    public List<SmartPhone> searchPhones(SmartPhoneSpec searchSpec) {
        List<SmartPhone> matchedSmartPhones = new ArrayList<>();

        for (SmartPhone smartPhone : inventory) {
            if (smartPhone.getSmartPhoneSpec().matches(searchSpec)) {
                matchedSmartPhones.add(smartPhone);
            }
        }
        return matchedSmartPhones;
    }


    /**
     * This method follows the same pattern as the properties:
     * We remove any duplication between the client's spec and the SmartPhone object
     *
     * @return smartphone details
     */
    public SmartPhoneSpec getSmartPhoneSpec() {
        return smartPhoneSpec;
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "serialNumber= " + serialNumber +
                ", price= $" + price +
                ", smartPhoneSpec= " + smartPhoneSpec +
                '}';
    }
}

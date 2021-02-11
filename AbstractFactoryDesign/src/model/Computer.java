package model;

import java.util.ArrayList;
import java.util.List;

/**
 *  a concrete implementation abstract class Computer.
 *  We are using this in Abstract Factory.
 */

public abstract class Computer {
    private static int count = 0;
    private int serialNumber; //unique to each Computer
    private double price; //unique to each Computer
    ComputerSpec computerSpec; // reference to ComputerSpec object for each Computer
    static List<Computer> inventory = new ArrayList<>();

    /**
     * Constructor for concrete classes PC and Server
     * Initializes PC and Server objects with given parameters and adds it to the computer inventory
     * @param computerSpec
     * @param price
     */
    public Computer(ComputerSpec computerSpec, double price) {
        this.computerSpec = computerSpec;
        this.price = price;
        this.serialNumber = ++count;
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

    /**
     * This method follows the same pattern as the properties:
     * We remove any duplication between the client's spec and the Computer object
     *
     * @return computer details
     */
    public ComputerSpec getComputerSpec() {
        return computerSpec;
    }

    /**
     * Returns the specific computer if the specified id matches with computer in the inventory
     *
     * @param id
     * @return
     */
    public Computer getComputer(int id) {
        for (Computer computer : inventory) {
            if (computer.getSerialNumber() == id) {
                return computer;
            }
        }
        return null;
    }

    /**
     * Returns list of computer object(s)
     * Loop through the list.
     * If the instance variable matches, it is added to return list
     *
     * @param searchSpec
     * @return
     */
    public List<Computer> searchComputers(ComputerSpec searchSpec) {
        List<Computer> matchedComputers = new ArrayList<>();

        for (Computer computer : inventory) {
            if (computer.getComputerSpec().matches(searchSpec)) {
                matchedComputers.add(computer);
            }
        }
        return matchedComputers;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "serialNumber= " + serialNumber +
                ", price= $" + price +
                ", computerSpec= " + computerSpec +
                '}';
    }


}


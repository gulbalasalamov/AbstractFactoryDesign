package model;

/**
 * Clients really aren’t providing a Computer object...
 * They don’t actually give us a computer to compare against the inventory.
 * This ComputerSpec object storing just the specs clients want to send to the search() method
 * Below properties and related methods are encapsulated away from Computer object into ComputerSpec to prevent duplicate code
 * Otherwise imagine the scenario:
 * If there’s an object for all the client’s specs, and then the Computer has all its properties,
 * we’ve got two getManufacturer() methods, two getType() methods...
 * that’s not good..
 * That's why Computer just has a variable pointing to a new object type storing all its properties
 * So we've encapsulated computer properties out of Computer and put them in separate object.
 */
public class ComputerSpec {
    private Manufacturer manufacturer;
    private Type type;
    private String model;
    private int ram;
    int monitor;
    private boolean coolingSystem;


    public ComputerSpec(Type type, Manufacturer manufacturer, String model, int ram,
                        int monitor, boolean coolingSystem) {
        this.manufacturer = manufacturer;
        this.type = type;
        this.ram = ram;
        this.model = model;
        this.monitor = monitor;
        this.coolingSystem = coolingSystem;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }


    public Type getType() {
        return type;
    }


    public int getRam() {
        return ram;
    }


    public int getMonitor() {
        return monitor;
    }

    public String getModel() {
        return model;
    }

    public boolean hasCoolingSystem() {
        return coolingSystem;
    }

    public boolean matches(ComputerSpec searchSpec) {
        return (type == searchSpec.type) && (ram == searchSpec.ram);
    }

    @Override
    public String toString() {
        return
                "manufacturer=" + manufacturer +
                        ", type=" + type +
                        ", model='" + model + '\'' +
                        ", ram=" + ram +
                        ", monitor=" + monitor +
                        ", coolingSystem=" + coolingSystem +
                        '}';
    }
}

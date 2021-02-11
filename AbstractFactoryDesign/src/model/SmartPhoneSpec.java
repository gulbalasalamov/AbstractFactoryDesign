package model;

/**
 * Clients really aren’t providing a SmartPhone object...
 * They don’t actually give us a smartphone to compare against the inventory.
 * This SmartPhoneSpec object storing just the specs clients want to send to the search() method
 * Below properties and related methods are encapsulated away from SmartPhone object into SmartPhoneSpec to prevent duplicate code
 * Otherwise imagine the scenario:
 * If there’s an object for all the client’s specs, and then the SmartPhone has all its properties,
 * we’ve got two getManufacturer() methods, two getType() methods...
 * that’s not good..
 * That's why SmartPhone just has a variable pointing to a new object type storing all its properties
 * So we've encapsulated smartphone properties out of SmartPhone and put them in separate object.
 */

public class SmartPhoneSpec {
    private Manufacturer manufacturer;
    private Type type;
    private String model;
    private int releaseYear;
    private boolean NFC;
    private boolean touchScreen;
    private boolean fastCharge;

    public SmartPhoneSpec(Type type, Manufacturer manufacturer, String model, int releaseYear, boolean NFC, boolean touchScreen, boolean fastCharge) {
        this.manufacturer = manufacturer;
        this.type = type;
        this.model = model;
        this.releaseYear = releaseYear;
        this.NFC = NFC;
        this.touchScreen = touchScreen;
        this.fastCharge = fastCharge;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Type getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean hasNFC() {
        return NFC;
    }

    public boolean hasTouchScreen() {
        return touchScreen;
    }

    public boolean hasFastCharge() {
        return fastCharge;
    }

    public boolean matches(SmartPhoneSpec searchSpec) {
        return (type == searchSpec.type) && (manufacturer == searchSpec.manufacturer);
    }

    @Override
    public String toString() {
        return
                "manufacturer=" + manufacturer +
                        ", type=" + type +
                        ", model='" + model + '\'' +
                        ", releaseYear=" + releaseYear +
                        ", NFC=" + NFC +
                        ", touchScreen=" + touchScreen +
                        ", fastCharge=" + fastCharge +
                        '}';
    }
}

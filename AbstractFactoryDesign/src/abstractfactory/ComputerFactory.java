package abstractfactory;

import interfaces.AbstractFactory;
import model.*;
import products.PC;
import products.Server;

/**
 * We are implementing AbstractFactory interface using the Factory Method design pattern
 */

public class ComputerFactory implements AbstractFactory<Computer> {
    @Override
    public Computer createComputer(String deviceType, ComputerSpec computerSpec, double price) {
        if (deviceType.equalsIgnoreCase(Type.SERVER.toString())) {
            return new Server(computerSpec,price);
        } else if (deviceType.equalsIgnoreCase(Type.PC.toString())) {
            return new PC(computerSpec,price);
        }
        return null;
    }

    @Override
    public Computer createSmartPhone(String deviceType, SmartPhoneSpec smartPhoneSpec, double price) {
        return null;
    }
}
package abstractfactory;

import interfaces.AbstractFactory;


/**
 * FactoryProvider class provides us with an implementation of ComputerFactory or SmartPhoneFactory
 * depending on the argument that we supply to the getFactory() method:
 */

public class FactoryProvider {
    public static AbstractFactory getFactory(String choice) {
        if ("computer".equalsIgnoreCase(choice)) {
            return new ComputerFactory();
        } else if ("smartphone".equalsIgnoreCase(choice)) {
            return new SmartPhoneFactory();
        }
        return null;
    }
}

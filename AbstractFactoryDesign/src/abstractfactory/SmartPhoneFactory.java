package abstractfactory;

import interfaces.AbstractFactory;
import model.*;
import products.AndroidPhone;
import products.IPhone;

/**
 * We are implementing AbstractFactory interface using the Factory Method design pattern
 */


public class SmartPhoneFactory implements AbstractFactory<SmartPhone> {

    @Override
    public SmartPhone createComputer(String deviceType, ComputerSpec computerSpec, double price) {
        return null;
    }

    @Override
    public SmartPhone createSmartPhone(String deviceType, SmartPhoneSpec smartPhoneSpec, double price) {
        if (deviceType.equalsIgnoreCase(Type.ANDROID.toString())) {
            return new AndroidPhone(smartPhoneSpec, price);
        } else if (deviceType.equalsIgnoreCase(Type.IPHONE.toString())) {
            return new IPhone(smartPhoneSpec, price);
        }
        return null;
    }
}
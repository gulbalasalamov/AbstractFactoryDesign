package interfaces;

import model.ComputerSpec;
import model.SmartPhoneSpec;

/**
 * Concrete implementations of AbstractFactory interface
 * The AbstractFactory interface deals with families of dependent objects.
 * In other words, this model allows us to create objects that follow a general pattern.
 *
 * @param <T>
 */

public interface AbstractFactory<T> {
    T createComputer(String deviceType, ComputerSpec computerSpec, double price);
    T createSmartPhone(String deviceType, SmartPhoneSpec smartPhoneSpec, double price);
}

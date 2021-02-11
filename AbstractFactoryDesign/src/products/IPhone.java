package products;

import model.SmartPhone;
import model.SmartPhoneSpec;


/**
 * Concrete implementation of IPhone class, family member of SmartPhone
 */

public class IPhone extends SmartPhone {

    public IPhone(SmartPhoneSpec smartPhoneSpec, double price) {
        super(smartPhoneSpec, price);
    }

    @Override
    public String message() {
        return "The iPhone is a line of smartphones designed and marketed by Apple Inc. that use Apple's iOS mobile operating system.";
    }


}

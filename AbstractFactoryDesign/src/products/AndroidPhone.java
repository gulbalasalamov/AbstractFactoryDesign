package products;

import model.SmartPhone;
import model.SmartPhoneSpec;

/**
 * Concrete implementation of AndroidPhone class, family member of SmartPhone
 */

public class AndroidPhone extends SmartPhone {

    public AndroidPhone(SmartPhoneSpec smartPhoneSpec, double price) {
        super(smartPhoneSpec, price);
    }

    @Override
    public String message() {
        return "Android is a mobile operating system based on a modified version of the Linux kernel and other open source software, " +
                "\ndesigned primarily for touchscreen mobile devices such as smartphones and tablets.";
    }

}

package products;

import model.Computer;
import model.ComputerSpec;

/**
 * Concrete implementation of PC class, family member of Computer
 */

public class PC extends Computer {

    public PC(ComputerSpec computerSpec, double price) {
        super(computerSpec, price);
    }


}

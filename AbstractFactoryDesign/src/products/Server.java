package products;

import model.Computer;
import model.ComputerSpec;

/**
 * Concrete implementation of Server class, family member of Computer
 */

public class Server extends Computer {

    public Server(ComputerSpec computerSpec, double price) {
        super(computerSpec,price);
    }


}

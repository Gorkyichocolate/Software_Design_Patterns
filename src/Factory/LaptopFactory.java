package Factory;

import Factory.Factory;
import Laptop.*;
import PersonalComputer.PersonalComputer;

public class LaptopFactory implements Factory {
    @Override
    public Laptop createLaptop(String typeOfLaptop) {
        return switch (typeOfLaptop) {
            case "Gaming" -> new Gaming();
            case "UltraBook" -> new UltraBook();
            case "NetBook" -> new NetBook();
            case "TransformerLaptop" -> new TransformerLaptop();
            default -> null;
        };
    }

    @Override
    public PersonalComputer createPersonalComputer(String typeOfComputers) {
        return null;
    }
}

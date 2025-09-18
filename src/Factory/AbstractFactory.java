package Factory;

import Factory.Factory;

public class AbstractFactory {
    public Factory createFactory(String typeOfFactory) {
        switch (typeOfFactory) {
            case "Laptop":
                return new LaptopFactory();
            case "PersonalComputer":
                return new PersonalComputerFactory();
            default:
                return null;
        }
    }
}

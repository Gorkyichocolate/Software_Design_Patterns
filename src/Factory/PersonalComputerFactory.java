package Factory;

import Laptop.Laptop;
import PersonalComputer.*;

public class PersonalComputerFactory implements Factory {
    @Override
    public PersonalComputer createPersonalComputer(String typeOfPC) {
        return switch (typeOfPC) {
            case "GamingPC" -> new GamingPC();
            case "OfficePC" -> new OfficePC();
            case "Monoblock" -> new Monoblock();
            default -> null;
        };
    }

    @Override
    public Laptop createLaptop(String typeOfLaptop){
        return null;
    }
}

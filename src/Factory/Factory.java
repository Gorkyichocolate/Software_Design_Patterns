package Factory;

import Laptop.Laptop;
import PersonalComputer.PersonalComputer;

public interface Factory {
    PersonalComputer createPersonalComputer(String typeOfPC);

    Laptop createLaptop(String typeOfLaptop);

}

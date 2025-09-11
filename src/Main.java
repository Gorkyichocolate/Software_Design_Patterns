//https://www.youtube.com/watch?v=-PX_4nEE7p8

public class Main {
    public static void main(String[] args) {
        Factory laptopsfactory = new AbstractFactory().createFactory("Laptops");
        Factory pcfactory = new AbstractFactory().createFactory("PersonalComputer");

        Laptops gaming = laptopsfactory.createLaptops("Gaming");
        Laptops ultrabook = laptopsfactory.createLaptops("UltraBook");

        gaming.power();
        ultrabook.power();

        PersonalComputer gamingpc = pcfactory.createPersonalComputers("Gaming");
        PersonalComputer officepc = pcfactory.createPersonalComputers("Office");

        gamingpc.power();
        officepc.power();

    }
}




interface Laptops{
    void power();
}
class Gaming implements Laptops{
    @Override
    public void power() {
        System.out.println("Gaming Laptops power");
    }
}
class UltraBook implements Laptops{
    @Override
    public void power() {
        System.out.println("UltraBook power");
    }
}
class LaptopsFactory implements Factory{
    @Override
    public Laptops createLaptops(String typeOfLaptops) {
        switch (typeOfLaptops){
            case "Gaming" : return new Gaming();
            case "UltraBook" : return new UltraBook();
            default: return null;
        }
    }
    @Override
    public PersonalComputer createPersonalComputers(String typeOfComputers) {
        return null;
    }
}



interface PersonalComputer{
    void power();
}
class GamingPC  implements PersonalComputer{
    @Override
    public void power() {
        System.out.println("Gaming PC power");
    }
}
class OfficePc implements PersonalComputer{
    @Override
    public void power() {
        System.out.println("Office PC power");
    }
}
class PersonalComputersFactory implements Factory {
    public PersonalComputer createPersonalComputers(String typeOfPC) {
        switch (typeOfPC){
            case "Gaming" : return new GamingPC();
            case "Office" : return new OfficePc();
            default: return null;
        }
    }
    @Override
    public Laptops createLaptops(String typeOfPC) {
        return null;
    }
}

interface Factory {
    Laptops createLaptops(String typeOfLaptops);
    PersonalComputer createPersonalComputers(String typeOfPersonalComputers);
}



class AbstractFactory{
    Factory createFactory(String typeOfFactory){
        switch (typeOfFactory){
            case "Laptops" : return new LaptopsFactory();
            case "PersonalComputer" : return new PersonalComputersFactory();
            default: return null;
        }
    }
}


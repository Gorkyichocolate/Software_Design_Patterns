//https://www.youtube.com/watch?v=-PX_4nEE7p8
//https://www.youtube.com/watch?v=A4uNotdECBg

public class Main {
    public static void main(String[] args) {
        Factory Laptopfactory = new AbstractFactory().createFactory("Laptop");
        Factory pcfactory = new AbstractFactory().createFactory("PersonalComputer");

        Laptop gaming = Laptopfactory.createLaptop("Gaming");
        Laptop ultrabook = Laptopfactory.createLaptop("UltraBook");
        Laptop netbook = Laptopfactory.createLaptop("NetBook");
        Laptop transformerlaptop = Laptopfactory.createLaptop("TransformerLaptop");

        System.out.println("Laptop factory created:");
        System.out.println("Gaming Laptop:");

        gaming.cpu();
        gaming.gpu();
        gaming.os();
        gaming.selled();

        System.out.println("UltraBook:");

        ultrabook.cpu();
        ultrabook.gpu();
        ultrabook.os();
        ultrabook.selled();

        System.out.println("NetBook:");

        netbook.cpu();
        netbook.gpu();
        netbook.os();
        netbook.selled();

        System.out.println("TransformerLaptop:");

        transformerlaptop.cpu();
        transformerlaptop.gpu();
        transformerlaptop.os();
        transformerlaptop.selled();
        
        System.out.println("PersonalComputer factory created:");

        PersonalComputer gamingpc = pcfactory.createPersonalComputers("Gaming");
        PersonalComputer officepc = pcfactory.createPersonalComputers("Office");
        PersonalComputer monoblock = pcfactory.createPersonalComputers("Monoblock");

        System.out.println("Gaming PC:");

        gamingpc.cpu();
        gamingpc.gpu();
        gamingpc.os();
        gamingpc.selled();

        System.out.println("Office PC:");

        officepc.cpu();
        officepc.gpu();
        officepc.os();
        officepc.selled();

        System.out.println("Monoblock:");

        monoblock.cpu();
        monoblock.gpu();
        monoblock.os();
        monoblock.selled();

    }
}



interface Laptop{
    void cpu();
    void gpu();    
    void os();
    void selled();
    
}
class Gaming implements Laptop{
    @Override
    public void cpu() {
        System.out.println("CPU has been installed in Gaming Laptop");
    }

    @Override
    public void gpu() {
        System.out.println("GPU has been installed in Gaming Laptop");
    }

    @Override
    public void os() {
        System.out.println("OS was installed in Gaming Laptop");
    }

    @Override
    public void selled() {
        System.out.println("Gaming Laptop in selling");
    }
}
class UltraBook implements Laptop{
    @Override
    public void cpu() {
        System.out.println("CPU has been installed in Ultrabook");
    }

    @Override
    public void gpu() {
        System.out.println("GPU hasn't installed in Ultrabook");
    }

    @Override
    public void os() {
        System.out.println("OS was installed in Ultrabook");
    }

    @Override
    public void selled() {
        System.out.println("UltraBook in selling");
    }
}

class NetBook implements Laptop{
    @Override
    public void cpu() {
        System.out.println("CPU has been installed in Netbook");
    }

    @Override
    public void gpu() {
        System.out.println("GPU hasn't installed in Netbook");
    }

    @Override
    public void os() {
        System.out.println("OS was installed in Netbook");
    }

    @Override
    public void selled() {
        System.out.println("Netbook in selling");
    }
}

class TransformerLaptop implements Laptop{
    @Override
    public void cpu() {
        System.out.println("CPU has been installed in TransformerLaptop");
    }

    @Override
    public void gpu() {
        System.out.println("GPU hasn't installed in TransformerLaptop");
    }

    @Override
    public void os() {
        System.out.println("OS was installed in TransformerLaptop");
    }

    @Override
    public void selled() {
        System.out.println("TransformerLaptop in selling");
    }
}




class LaptopFactory implements Factory{
    @Override
    public Laptop createLaptop(String typeOfLaptop) {
        switch (typeOfLaptop){
            case "Gaming" : return new Gaming();
            case "UltraBook" : return new UltraBook();
            case "NetBook" : return new NetBook();
            case "TransformerLaptop" : return new TransformerLaptop();
            default: return null;
        }
    }
    @Override
    public PersonalComputer createPersonalComputers(String typeOfComputers) {
        return null;
    }
}

interface PersonalComputer{
    void cpu();
    void gpu();
    void os();
    void selled();
}

class GamingPC  implements PersonalComputer{
    @Override
    public void cpu() {
        System.out.println("CPU has been installed in Gaming PC");
    }

    @Override
    public void gpu() {
        System.out.println("GPU has been installed in Gaming PC");
    }

    @Override
    public void os() {
        System.out.println("OS was installed in Gaming PC ");
    }
    
    @Override
    public void selled() {
        System.out.println("Gaming PC in selling");
    }
}

class OfficePc implements PersonalComputer{
    @Override
    public void cpu() {
        System.out.println("CPU has been installed in Office PC");
    }

    @Override
    public void gpu() {
        System.out.println("GPU has been installed in Office PC OFF");
    }

    @Override
    public void os() {
        System.out.println("OS was installed in Office PC");
    }

    @Override
    public void selled() {
        System.out.println("Office PC in selling");
    }
}


class Monoblock implements PersonalComputer{
    @Override
    public void cpu() {
        System.out.println("CPU has been installed in Monoblock");
    }

    @Override
    public void gpu() {
        System.out.println("GPU has been installed in Monoblock");
    }

    @Override
    public void os() {
        System.out.println("OS was installed in Monoblock");
    }

    @Override
    public void selled() {
        System.out.println("Monoblock in selling");
    }
}

class PersonalComputersFactory implements Factory {
    public PersonalComputer createPersonalComputers(String typeOfPC) {
        switch (typeOfPC){
            case "Gaming" : return new GamingPC();
            case "Office" : return new OfficePc();
            case "Monoblock" : return new Monoblock();
            default: return null;
        }
    }
    @Override
    public Laptop createLaptop(String typeOfPC) {
        return null;
    }
}

interface Factory {
    Laptop createLaptop(String typeOfLaptop);
    PersonalComputer createPersonalComputers(String typeOfPersonalComputers);
}


//
class AbstractFactory{
    Factory createFactory(String typeOfFactory){
        switch (typeOfFactory){
            case "Laptop" : return new LaptopFactory();
            case "PersonalComputer" : return new PersonalComputersFactory();
            default: return null;
        }
    }
}


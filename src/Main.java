//https://www.youtube.com/watch?v=-PX_4nEE7p8
//https://www.youtube.com/watch?v=A4uNotdECBg

import Factory.AbstractFactory;
import Factory.Factory;
import Laptop.Laptop;
import PersonalComputer.PersonalComputer;

public class Main {
    public static void main(String[] args) {
        Factory Laptopfactory = new AbstractFactory().createFactory("Laptop");
        Factory pcfactory = new AbstractFactory().createFactory("PersonalComputer");

        Laptop gaming = Laptopfactory.createLaptop("Gaming");
        Laptop ultrabook = Laptopfactory.createLaptop("UltraBook");
        Laptop netbook = Laptopfactory.createLaptop("NetBook");
        Laptop transformerlaptop = Laptopfactory.createLaptop("TransformerLaptop");

        PersonalComputer gamingpc = pcfactory.createPersonalComputer("GamingPC");
        PersonalComputer officepc = pcfactory.createPersonalComputer("OfficePC");
        PersonalComputer monoblock = pcfactory.createPersonalComputer("Monoblock");

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



class AbstractFactory {
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

interface Factory {
    PersonalComputer createPersonalComputer(String typeOfPC);

    Laptop createLaptop(String typeOfLaptop);

}

class PersonalComputerFactory implements Factory {
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

class LaptopFactory implements Factory {
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


interface PersonalComputer {
    public void cpu();

    public void gpu();

    public void os();

    public void selled();
}

interface Laptop {
    public void cpu();

    public void gpu();

    public void os();

    public void selled();

}

class Gaming implements Laptop {
    @Override
    public void cpu() {
        System.out.println("CPU has been installed in Gaming Laptop");
    }

    @Override
    public void gpu() { System.out.println("GPU has been installed in Gaming Laptop"); }

    @Override
    public void os() {
        System.out.println("OS was installed in Gaming Laptop");
    }

    @Override
    public void selled() {
        System.out.println("Gaming Laptop in selling");
    }
}

class GamingPC implements PersonalComputer {
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
    public void selled() { System.out.println("Gaming PC in selling"); }
}
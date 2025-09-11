public class Main {
    public static void main(String[] args) {
        Factory factory =  new Factory();
        Laptops gaming = factory.create("Gaming");
        Laptops ultrabook = factory.create("UltraBook");
        gaming.power();
        ultrabook.power();
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


class Factory{
    public Laptops create(String typeOfLaptops) {
        switch (typeOfLaptops){
            case "Gaming" : return new Gaming();
            case "UltraBook" : return new UltraBook();
            default: return null;
        }
    }
}
//
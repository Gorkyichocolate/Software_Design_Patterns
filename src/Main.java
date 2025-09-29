interface Laptop {
    void doSomething();
}

class WindowsLaptop implements Laptop {
    @Override
    public void doSomething() {
        System.out.println("Windows OS");
    }
}

class MacLaptop implements Laptop {
    @Override
    public void doSomething() {
        System.out.println("macOS");
    }
}


abstract class TypeOfLaptop {
    protected Laptop laptop;

    public TypeOfLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public abstract void doSomething();
}


class GamingLaptop extends TypeOfLaptop {
    public GamingLaptop(Laptop laptop) {
        super(laptop);
    }

    @Override
    public void doSomething() {
        System.out.println("Playing Game");
        laptop.doSomething();
    }
}

class UltrabookLaptop extends TypeOfLaptop {
    public UltrabookLaptop(Laptop laptop) {
        super(laptop);
    }

    @Override
    public void doSomething() {
        System.out.println("Studying");
        laptop.doSomething();
    }
}

class OfficeLaptop extends TypeOfLaptop {
    public OfficeLaptop(Laptop laptop) {
        super(laptop);
    }

    @Override
    public void doSomething() {
        System.out.println("Working");
        laptop.doSomething();
    }
}

public class Main {
    public static void main(String[] args) {
        TypeOfLaptop gamingWin = new GamingLaptop(new WindowsLaptop());
        gamingWin.doSomething();

        TypeOfLaptop ultraMac = new UltrabookLaptop(new MacLaptop());
        ultraMac.doSomething();
    }
}

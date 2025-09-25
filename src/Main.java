public class Main {
    public static void main(String[] args) {
        MacOS macUser = new MacUser(); // объект MacOS
        Windows11 programming = new VirtualMachine(macUser);
        App app = new App();
        app.ios(programming);
    }
}

interface Windows11 {
    void getProgramming();
}

interface MacOS {
    void getSwift();
}

class VirtualMachine implements Windows11 {
    MacOS macOS;

    public VirtualMachine(MacOS macOS) {
        this.macOS = macOS;
    }

    @Override
    public void getProgramming() {
        macOS.getSwift();
    }
}

class MacUser implements MacOS {
    @Override
    public void getSwift() {
        System.out.println("Programming on Swift");
    }
}

class App {
    public void ios(Windows11 programming) {
        programming.getProgramming();
    }
}

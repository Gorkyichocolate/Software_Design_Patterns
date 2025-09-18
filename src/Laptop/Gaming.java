package Laptop;

public class Gaming implements Laptop {
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

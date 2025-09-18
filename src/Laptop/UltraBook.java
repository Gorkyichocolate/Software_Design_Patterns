package Laptop;

public class UltraBook implements Laptop {
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

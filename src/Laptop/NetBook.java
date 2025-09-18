package Laptop;

public class NetBook implements Laptop {
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

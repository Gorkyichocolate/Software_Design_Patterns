package Laptop;

public class TransformerLaptop implements Laptop {
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

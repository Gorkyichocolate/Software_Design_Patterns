package PersonalComputer;


public class Monoblock implements PersonalComputer {
    @Override
    public void cpu() { System.out.println("CPU has been installed in Monoblock"); }

    @Override
    public void gpu() { System.out.println("GPU has been installed in Monoblock"); }

    @Override
    public void os() { System.out.println("OS was installed in Monoblock"); }

    @Override
    public void selled() { System.out.println("Monoblock in selling"); }
}

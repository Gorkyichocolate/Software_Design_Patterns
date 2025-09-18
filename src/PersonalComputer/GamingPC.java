package PersonalComputer;


public class GamingPC implements PersonalComputer {
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

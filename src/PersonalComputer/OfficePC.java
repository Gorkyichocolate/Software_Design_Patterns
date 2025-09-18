package PersonalComputer;


public class OfficePC implements PersonalComputer {
    @Override
    public void cpu() {
        System.out.println("CPU has been installed in Office PC");
    }

    @Override
    public void gpu() {
        System.out.println("GPU has been installed in Office PC");
    }

    @Override
    public void os() {
        System.out.println("OS was installed in Office PC");
    }

    @Override
    public void selled() {
        System.out.println("Office PC in selling");
    }
}

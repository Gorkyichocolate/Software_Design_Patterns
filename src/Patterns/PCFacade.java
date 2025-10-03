package Patterns;

public class PCFacade {
    public static void main(String[] args){
        PCFacadeClass pc = new PCFacadeClass();
        pc.startPc();
    }
}

class Gpu {
    void videocard() {
        System.out.println("GPU is working");
    }
}

class Cpu {
    void processor() {
        System.out.println("CPU is working");
    }
}

class Ram{
    void ram() {
        System.out.println("RAM is working");
    }
}

class Motherboard{
    void motherboard() {
        System.out.println("Patterns.Motherboard is working");
    }
}

class Bios{
    void bios() {
        System.out.println("BIOS is working");
    }
}

class Memory{
    void memory() {
        System.out.println("Patterns.Memory is working");
    }
}

class PCFacadeClass{
    Gpu gpu = new Gpu();
    Cpu cpu = new Cpu();
    Ram ram = new Ram();
    Motherboard motherboard = new Motherboard();
    Bios bios = new Bios();
    Memory memory = new Memory();

    public void startPc() {
        gpu.videocard();
        cpu.processor();
        ram.ram();
        motherboard.motherboard();
        bios.bios();
        memory.memory();
    }
}


public class Main {
    public static void main(String[] args) {
        PersonalComputer personalComputer = new PersonalComputerImpl().setCPU("I5-10400F").build();
        personalComputer.printPersonalComputer();
    }
}

class PersonalComputer{
    String CPU;
    String VideoCard;
    String Motherboard;
    int RamCapacity;
    int RAM;
    int HDDMemoryCapacity;
    int SSDMemoryCapacity;
    int PowerSupply;
    String Monitor;
    String MonitorResolution;
    int MonitorHZ;
    String Keyboard;
    String KeyboardType;
    String KeyboardSize;
    String Mouse;
    String MouseDPI;
    public void printPersonalComputer(){
        System.out.println("CPU:"+CPU);
        System.out.println("VideoCard:"+VideoCard);
        System.out.println("Motherboard:"+Motherboard);
        System.out.println("RAM:"+RAM);
        System.out.println("HDDMemory:"+HDDMemoryCapacity);
        System.out.println("SSDMemory:"+SSDMemoryCapacity);
        System.out.println("PowerSupply:"+PowerSupply);
        System.out.println("Monitor:"+Monitor);
        System.out.println("MonitorResolution:"+MonitorResolution);
        System.out.println("MonitorHZ:"+MonitorHZ);
        System.out.println("Keyboard:"+Keyboard);
        System.out.println("KeyboardType:"+KeyboardType);
        System.out.println("KeyboardSize:"+KeyboardSize);
        System.out.println("Mouse:"+Mouse);
        System.out.println("MouseDPI:"+MouseDPI);
    }
}

interface PersonalComputerBuilder{
    PersonalComputerBuilder setCPU(String CPU);
    PersonalComputerBuilder setVideoCard(String VideoCard);
    PersonalComputerBuilder setMotherboard(String Motherboard);
    PersonalComputerBuilder setRAM(int RAM);
    PersonalComputerBuilder setHDDMemoryCapacity(int HDDMemoryCapacity);
    PersonalComputerBuilder setSSDMemoryCapacity(int SSDMemoryCapacity);
    PersonalComputerBuilder setPowerSupply(int PowerSupply);
    PersonalComputerBuilder setMonitor(String Monitor);
    PersonalComputerBuilder setMonitorResolution(String MonitorResolution);
    PersonalComputerBuilder setMonitorHZ(int MonitorHZ);
    PersonalComputerBuilder setKeyboard(String Keyboard);
    PersonalComputerBuilder setKeyboardType(String KeyboardType);
    PersonalComputerBuilder setKeyboardSize(String KeyboardSize);
    PersonalComputerBuilder setMouse(String Mouse);
    PersonalComputerBuilder setMouseDPI(String MouseDPI);
    PersonalComputer build();
}

class PersonalComputerImpl implements PersonalComputerBuilder{
    PersonalComputer personalComputer =  new PersonalComputer();

    @Override
    public PersonalComputerBuilder setCPU(String CPU) {
        personalComputer.CPU = CPU;
        return this;
    }

    @Override
    public PersonalComputerBuilder setVideoCard(String VideoCard) {
        personalComputer.VideoCard = VideoCard;
        return this;
    }

    @Override
    public PersonalComputerBuilder setMotherboard(String Motherboard) {
        personalComputer.Motherboard = Motherboard;
        return this;
    }

    @Override
    public PersonalComputerBuilder setRAM(int RAM) {
        personalComputer.RAM = RAM;
        return this;
    }

    @Override
    public PersonalComputerBuilder setHDDMemoryCapacity(int HDDMemoryCapacity) {
        personalComputer.HDDMemoryCapacity = HDDMemoryCapacity;
        return this;
    }

    @Override
    public PersonalComputerBuilder setSSDMemoryCapacity(int SSDMemoryCapacity) {
        personalComputer.SSDMemoryCapacity = SSDMemoryCapacity;
        return this;
    }

    @Override
    public PersonalComputerBuilder setPowerSupply(int PowerSupply) {
        personalComputer.PowerSupply = PowerSupply;
        return this;
    }

    @Override
    public PersonalComputerBuilder setMonitor(String Monitor) {
        personalComputer.Monitor = Monitor;
        return this;
    }

    @Override
    public PersonalComputerBuilder setMonitorResolution(String MonitorResolution) {
        personalComputer.MonitorResolution = MonitorResolution;
        return this;
    }

    @Override
    public PersonalComputerBuilder setMonitorHZ(int MonitorHZ) {
        personalComputer.MonitorHZ = MonitorHZ;
        return this;
    }

    @Override
    public PersonalComputerBuilder setKeyboard(String Keyboard) {
        personalComputer.Keyboard = Keyboard;
        return this;
    }

    @Override
    public PersonalComputerBuilder setKeyboardType(String KeyboardType) {
        personalComputer.KeyboardType = KeyboardType;
        return this;
    }

    @Override
    public PersonalComputerBuilder setKeyboardSize(String KeyboardSize) {
        personalComputer.KeyboardSize = KeyboardSize;
        return this;
    }

    @Override
    public PersonalComputerBuilder setMouse(String Mouse) {
        personalComputer.Mouse = Mouse;
        return this;
    }

    @Override
    public PersonalComputerBuilder setMouseDPI(String MouseDPI) {
        personalComputer.MouseDPI = MouseDPI;
        return this;
    }

    @Override
    public PersonalComputer build() {
        return personalComputer;
    }
}

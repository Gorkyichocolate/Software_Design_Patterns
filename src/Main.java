import MacOS.*;
import Windows11.*;
import Target.*;

public class Main {
    public static void main(String[] args) {
        MacOS macUser = new MacUser(); // объект MacOS.MacOS
        Windows11 programming = new VirtualMachine(macUser);
        Windows11 videoStudio = new VirtualMachine(macUser);
        Windows11 audioStudio = new VirtualMachine(macUser);
        App app = new App();
        Video video = new Video();
        Audio audio = new Audio();
        app.xcode(programming);
        audio.logicPro(audioStudio);
        video.finalCutPro(videoStudio);
    }
}


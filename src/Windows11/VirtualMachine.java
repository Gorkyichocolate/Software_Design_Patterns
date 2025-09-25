package Windows11;

import MacOS.MacOS;
import Windows11.Windows11;

public class VirtualMachine implements Windows11 {
    MacOS macOS;

    public VirtualMachine(MacOS macOS) {
        this.macOS = macOS;
    }

    @Override
    public void getProgramming() {
        macOS.getXcode();
    }

    @Override
    public void getAudioStudio() {
        macOS.getAudioStudio();
    }

    @Override
    public void getVideoStudio() {
        macOS.getVideoStudio();
    }

}

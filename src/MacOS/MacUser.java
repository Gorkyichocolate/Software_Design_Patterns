package MacOS;

import MacOS.MacOS;

public class MacUser implements MacOS {
    @Override
    public void getXcode() {
        System.out.println("Programming on Swift");
    }

    @Override
    public void getAudioStudio() {
        System.out.println("Audio editing on Logic Pro via MacOS");
    }

    @Override
    public void getVideoStudio() {
        System.out.println("Making videos on Final Cut PRO via MacOS");
    }
}

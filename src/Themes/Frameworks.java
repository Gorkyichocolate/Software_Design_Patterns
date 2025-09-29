package Themes;

import Bridge.Learn;
import Bridge.Themes;

public class Frameworks extends Themes {
    public Frameworks(Learn learn) {
        super(learn);
    }

    @Override
    public void studying() {
        System.out.println("Frameworks");
        learn.learning();
    }

}

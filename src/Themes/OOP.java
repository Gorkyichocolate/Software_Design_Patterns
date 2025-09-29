package Themes;

import Bridge.Learn;
import Bridge.Themes;

public class OOP extends Themes {
    public OOP(Learn learn) {
        super(learn);
    }

    @Override
    public void studying() {
        System.out.println("OOP");
        learn.learning();
    }

}

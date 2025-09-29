package Themes;

import Bridge.Learn;
import Bridge.Themes;

public class Libraries extends Themes {
    public Libraries(Learn learn) {
        super(learn);
    }

    @Override
    public void studying() {
        System.out.println("Libraries");
        learn.learning();
    }

}

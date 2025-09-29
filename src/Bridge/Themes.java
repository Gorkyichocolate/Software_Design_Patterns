package Bridge;

import Bridge.Learn;

public abstract class Themes {
    public Learn learn;

    public Themes(Learn learn) {
        this.learn = learn;
    }

    public abstract void studying();
}

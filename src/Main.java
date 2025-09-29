interface Learn{
    void learning();
}

class Java implements Learn{
    public void learning(){
        System.out.println("Java");
    }
}

class Python implements Learn{
    public void learning(){
        System.out.println("Python");
    }
}

class Javascript implements Learn{
    public void learning(){
        System.out.println("Javascript");
    }
}

abstract class Themes{
    protected Learn learn;

    public Themes(Learn learn){
        this.learn = learn;
    }

    abstract void studying();
}

class OOP extends Themes{
    public OOP(Learn learn){
        super(learn);
    }

    @Override
    void studying(){
        System.out.println("OOP");
        learn.learning();
    }

}

class Libraries extends Themes{
    public Libraries(Learn learn){
        super(learn);
    }

    @Override
    void studying(){
        System.out.println("Libraries");
        learn.learning();
    }

}

class Frameworks extends Themes{
    public Frameworks(Learn learn){
        super(learn);
    }

    @Override
    void studying(){
        System.out.println("Frameworks");
        learn.learning();
    }

}

public class Main {
    public static void main(String[] args) {

        Learn java = new Java();
        Themes oopJava = new OOP(java);
        oopJava.studying();
        System.out.println();


        Learn python = new Python();
        Themes librariesPython = new Libraries(python);
        librariesPython.studying();
        System.out.println();


        Learn javascript = new Javascript();
        Themes frameworksJS = new Frameworks(javascript);
        frameworksJS.studying();
        System.out.println();


        Themes oopPython = new OOP(python);
        oopPython.studying();
        System.out.println();


        Themes librariesJava = new Libraries(java);
        librariesJava.studying();
    }
}







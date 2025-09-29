import Bridge.Learn;
import Bridge.Themes;
import Languages.Java;
import Languages.Javascript;
import Languages.Python;
import Themes.Frameworks;
import Themes.Libraries;
import Themes.OOP;

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

    }
}







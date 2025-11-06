import Visitor.*;

public class Main {
    public static void main(String[] args) {

        Teachers daa = new DAA();

        Teachers sdp = new SDP();

        Teachers frontend = new Frontend();

        daa.doTeach(new ConcreteVisitor());

        sdp.doTeach(new ConcreteVisitor());

        frontend.doTeach(new ConcreteVisitor());

    }
}
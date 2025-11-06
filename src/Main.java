import Visitor.*;

public class Main {
    public static void main(String[] args) {
        Teachers daa = new DAA();
        Teachers sdp = new SDP();
        Teachers frontend = new Frontend();

        daa.doJob(new ConcreteVisitor());
        sdp.doJob(new ConcreteVisitor());
        frontend.doJob(new ConcreteVisitor());
    }
}
package Visitor;

public class SDP implements Teachers {
    @Override
    public void doJob(Visitor visitor) {
        visitor.doSDP();
    }
}

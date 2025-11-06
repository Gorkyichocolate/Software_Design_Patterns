package Visitor;

public class SDP implements Teachers {
    @Override
    public void doTeach(Visitor visitor) {
        visitor.doSDP();
    }
}

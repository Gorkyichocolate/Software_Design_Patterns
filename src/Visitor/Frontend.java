package Visitor;

public class Frontend implements Teachers {
    @Override
    public void doJob(Visitor visitor) {
        visitor.doWT();
    }
}

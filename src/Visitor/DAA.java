package Visitor;

public class DAA implements Teachers {    @Override
    public void doJob(Visitor visitor) {
        visitor.doDAA();
    }
}

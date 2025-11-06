package Visitor;

public class DAA implements Teachers {    @Override
    public void doTeach(Visitor visitor) {
        visitor.doDAA();
    }
}

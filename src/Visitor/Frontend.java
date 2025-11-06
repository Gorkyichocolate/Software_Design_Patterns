package Visitor;

public class Frontend implements Teachers {
    @Override
    public void doTeach(Visitor visitor) {
        visitor.doWT();
    }
}

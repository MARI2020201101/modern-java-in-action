package ch15.reactive;

public class ArithmeticCell extends SimpleCell{

    int left;
    int right;
    public ArithmeticCell(String name) {
        super(name);
    }

    public void setLeft(int left){
        this.left = left;
        this.onNext(left);
    }
    public void setRight(int right){
        this.right = right;
        this.onNext(right);
    }
}

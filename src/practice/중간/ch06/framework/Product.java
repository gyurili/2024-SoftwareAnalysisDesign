package practice.ch06.framework;

public interface Product extends Cloneable { //(셤)
    //추상 메소드
    public abstract void use(String s);
    public abstract Product createCopy(); //복제 기능
}

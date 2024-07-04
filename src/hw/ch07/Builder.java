package hw.ch07;

// public abstract class Builder {
// 인스턴스 구축을 위한 인터페이스(API)를 결정한다.
public interface Builder {
    // 문서를 만드는데 필요한 부품을 만들어주는 메소드 (추상) <- Director 클래스가 활용함
    public abstract void makeTitle(String title);
    public abstract void makeString(String str);
    public abstract void makeItems(String[] items);
    public abstract void close();
}

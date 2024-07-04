package hw.ch03;

public abstract class AbstractDisplay {

    public abstract void open();
    public abstract void print();
    public abstract void close();

    //times회만큼 for문 반복
    public final void display(int times) { //(셤) final 키워드
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}



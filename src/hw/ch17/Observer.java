package hw.ch17;

//관찰자
public interface Observer {
    public abstract void update(NumberGenerator generator); //통지 받는 메소드, 갱신을 알림 (관찰 대상자만 넘겨줌)
}

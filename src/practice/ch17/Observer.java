package practice.ch17;

// 관찰자를 나타내는 인터페이스
public interface Observer {
    public abstract void update(NumberGenerator generator); //통지 받는 메소드, 갱신을 알림 (관찰 대상자만 넘겨줌)
    // public abstract void update(NumberGenerator generator, int number); //이것도 가능! (관찰 대상자와 갱신된 정보를 넘겨줌)
    // public abstract void update(int number); //이것도 가능! (갱신된 정보만 넘겨줌)
}

package practice.ch14;

// 1) 항상 아무것도 처리하지 않음 (support 하위 클래스)
public class NoSupport extends Support {
    public NoSupport(String name) {
        super(name); // 부모 생성자 호출
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false; // 자신은 아무것도 해결하지 않는다 (항상 false 반환)
    }
}

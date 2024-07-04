package practice.ch14;

// 3) 홀수 번호 트러블만 해결 (support 하위 클래스)
public class OddSupport extends Support {

    // 생성자
    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        // 홀수일 때만 해결
        if (trouble.getNumber() % 2 == 1) {
            return true;
        } else { // 해결 못하면
            return false; // false 반환
        }
    }
}

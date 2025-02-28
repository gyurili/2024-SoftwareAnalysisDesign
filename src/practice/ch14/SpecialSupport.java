package practice.ch14;

// 4) 특정 번호 트러블만 해결 (support 하위 클래스)
public class SpecialSupport extends Support {
    private int number; // 이 번호만 해결할 수 있다

    public SpecialSupport(String name, int number) {
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() == number) {
            return true;
        } else {
            return false;
        }
    }
}

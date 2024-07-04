package practice.ch14;

// 2) 지정한 번호 미만의 트러블만 해결 (support 하위 클래스)
public class LimitSupport extends Support {
    private int limit; // 이 번호 미만이면 해결할 수 있다

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() < limit) {
            return true;
        } else {
            return false;
        }
    }
}

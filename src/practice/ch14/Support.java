package practice.ch14;

// 트러블을 해결하는 추상 클래스 (Handler [처리자])
public abstract class Support {
    private String name;    // 이 트러블의 해결자 이름
    private Support next;   // 떠넘길 곳 (부모 타입으로 선언됨)

    public Support(String name) {
        this.name = name;
        this.next = null; // 초기화
    }

    // 떠넘길 곳을 설정한다
    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    // 트러블 해결 절차를 결정한다 [템플릿 메소드 사용]
    // 반환값이 false이면 다음 해결자에게 넘김
    // 방법 1) 재귀적 호출
    public void support(Trouble trouble) {
        if (resolve(trouble)) { // 내가 해결했다면 ..
            done(trouble);
        } else if (next != null) { // 내가 해결 못하고, 뒷 사람이 있다면 ..
            next.support(trouble); // 뒷사람에게 넘긴다. (재귀적 호출)
        } else { // 전부 다 해결 못하면 .. (뒷사람이 없으면, 내가 맨 마지막이면)
            fail(trouble); // 실패
        }
    }
    

    /* 
    // 방법 2) for 루프로 구현
    public void support(Trouble trouble) {
        for (Support obj = this ; true ; obj = obj.next) { // obj = obj.next 중요!
            if (obj.resolve(trouble)) { // 내가 해결했다면 ..
                obj.done(trouble);
                break; // for문 빠져나오기
            } 
            else if (obj.next == null) { // (뒷사람이 없으면, 내가 맨 마지막이면)
                obj.fail(trouble); // 실패
                break; // for문 빠져나오기
            }
        }
    }
    */

    // 트러블 해결자의 문자열 표현
    @Override
    public String toString() {
        return "[" + name + "]";
    }

    // 해결하려고 한다
    protected abstract boolean resolve(Trouble trouble); // abstract = 자식들이 구현함

    // 해결했다 
    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    // 해결되지 않았다 
    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }
}

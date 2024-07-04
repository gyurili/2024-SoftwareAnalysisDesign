package practice.ch16;

// 멤버의 인터페이스를 정하는 인터페이스
// 카운셀러에게 상담하러 오는 멤버를 나타내는 인터페이스
public interface Colleague {
    // Mediator를 설정한다 (="내가 카운셀러야~" 알리기)
    public abstract void setMediator(Mediator mediator);

    // 카운셀러가 내리는 지시
    // Mediator에서 활성/비활성을 지시한다
    public abstract void setColleagueEnabled(boolean enabled);
}

package practice.ch16;

// 중재자의 인터페이스를 정하는 인터페이스
public interface Mediator {
    // Mediator가 관리하는 Colleague 멤버를 생성한다 
    public abstract void createColleagues();

    // Colleage의 상태가 변화했을 때 호출된다 (각 멤버가 상담을 요청했을 때)
    public abstract void colleagueChanged(); //통지 받을 때 메소드
}

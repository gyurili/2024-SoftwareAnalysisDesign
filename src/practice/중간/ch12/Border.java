package practice.ch12;

public abstract class Border extends Display {
    // 이 장식틀이 감싸는 '내용물'
    protected Display display;             

    // 인스턴스 생성 시 '내용물'을 인수로 지정
    protected Border(Display display) { 
        this.display = display;
    }
}

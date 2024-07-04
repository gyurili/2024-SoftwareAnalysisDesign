package hw.ch05;

import hw.ch05.idcard.IDCardFactoryPGR2;

public class Main2 extends Thread { //Thread를 상속받아 멀티스레딩을 구현
    public static void main(String[] args) {
        
        System.out.println("20220526 박규리");
        
        //Main2 객체 3개 생성 => 각각 start( ) 메소드 호출
        System.out.println("Start.");
        new Main2("최승훈").start();
        new Main2("박규리").start();
        new Main2("홍길동").start();
        System.out.println("End.");
    }

    @Override
    public void run() {
        IDCardFactoryPGR2 obj = IDCardFactoryPGR2.getInstance(); //인스턴스를 가져옴
        System.out.println(getName() + ": obj = " + obj); //자신의 이름과 인스턴스 주소 출력
    }

    public Main2(String name) {
        super(name);
    }
}


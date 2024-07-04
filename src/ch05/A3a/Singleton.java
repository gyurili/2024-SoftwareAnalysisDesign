package ch05.A3a;

public class Singleton {
    private static Singleton singleton = null;

    private Singleton() {
        System.out.println("인스턴스가 생성되었습니다.");
        slowdown(); // 싱글턴 객체 생성을 오래 걸리게 함 
    }

    public static synchronized Singleton getInstance() { //synchronized = 중요! 동기화, 객체 순서대로 생성함
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    private void slowdown() {
        try {
            Thread.sleep(1000); // sleep: CPU를 내놓고 1초간 쉰다는 명령어
        } catch (InterruptedException e) {
        }
    }
}

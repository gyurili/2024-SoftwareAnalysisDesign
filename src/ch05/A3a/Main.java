package ch05.A3a;

public class Main extends Thread { //Thread 상속 받아서 사용 (main 클래스 자체가 스래드가 됨)
    public static void main(String[] args) {
        System.out.println("Start.");

        //스래드 객체 3개 생성해서 실행시킴
        new Main("A").start();
        new Main("B").start();
        new Main("C").start();
        System.out.println("End.");
    }

    @Override
    public void run() { //스레드가 해야 하는 일
        Singleton obj = Singleton.getInstance();
        System.out.println(getName() + ": obj = " + obj); //객체의 주소가 출력
    }

    public Main(String name) {
        super(name);
    }
}

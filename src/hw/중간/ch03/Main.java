package hw.ch03;

public class Main {
    public static void main(String[] args) {
        System.out.println("20220526 박규리");

        //ParkgyuriDisplay로 객체 생성, 인자 = 이름, 학번, 학년
        AbstractDisplay x = new ParkgyuriDisplay("박규리", "20220526", 3);

        int times;
        
        //5번 호출
        times = 5;
        x.display(times);

        //10번 호출
        times = 10;
        x.display(times);
    }
}

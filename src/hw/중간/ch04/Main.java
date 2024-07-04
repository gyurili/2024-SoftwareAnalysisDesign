package hw.ch04;

import hw.ch04.framework.Product;
import hw.ch04.car.carFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("<<20220526 박규리>>");

        carFactory factory = new carFactory(); //CarFactory 객체 생성

        Product car1 = factory.create("박규리"); //각각의 car 생성
        Product car2 = factory.create("그랜저");
        Product car3 = factory.create("소나타");
        Product car4 = factory.create("캐스퍼");

        car1.use(); //use 호출
        car2.use();
        car3.use();
        car4.use();

        factory.printAllModelNames(); //모든 차의 모델명 출력
    }
}

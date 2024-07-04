package hw.ch05;

import hw.ch05.idcard.IDCardFactoryPGR1;

public class Main1 {
    public static void main(String[] args) {

        System.out.println("20220526 박규리");

        //인스턴스를 가져와서 factory1, factory2 생성
        IDCardFactoryPGR1 factory1 = IDCardFactoryPGR1.getInstance();

        IDCardFactoryPGR1 factory2 = IDCardFactoryPGR1.getInstance();

        System.out.println(factory1);
        System.out.println(factory2);

        //두 인스턴스가 같은지, 다른지 비교
        if (factory1 == factory2){
            System.out.println("factory1과 factory2는 같은 인스턴스 입니다");
        }
        else {
            System.out.println("factory1과 factory2는 다른 인스턴스 입니다");
        }
        
    }
    
}


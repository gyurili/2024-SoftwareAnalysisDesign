package hw.ch05.idcard;

import hw.ch05.framework.Factory;
import hw.ch05.framework.Product;

public class IDCardFactoryPGR2 extends Factory {

    private static IDCardFactoryPGR2 IDCardFactoryPGR2 = null; //null을 사용하여 인스턴스 생성을 지연시킴
    
    //생성자
    private IDCardFactoryPGR2(){
        System.out.println("인스턴스를 생성했습니다.");
        slowdown(); //인스턴스 생성에 지연 추가
    }

    //synchronized 사용, 멀티스레드에서도 인스턴스가 단 한 번만 생성되도록 함
    public static synchronized IDCardFactoryPGR2 getInstance() {
        if (IDCardFactoryPGR2 == null) { //인스턴스 생성 전 ..
            IDCardFactoryPGR2 = new IDCardFactoryPGR2(); 
        }
        return IDCardFactoryPGR2; //인스턴스가 이미 있다면 새로 생성 X
    }

    private void slowdown() {
        try {
            Thread.sleep(3000); //인스턴스 생성 시 3초 지연 발생
        } catch (InterruptedException e) {
        }
    }

    //ch04 코드와 동일
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}

package hw.ch05.idcard;

import hw.ch05.framework.Factory;
import hw.ch05.framework.Product;

public class IDCardFactoryPGR1 extends Factory {

    //인스턴스 하나를 미리 생성
    private static IDCardFactoryPGR1 s = new IDCardFactoryPGR1();

    //생성자
    private IDCardFactoryPGR1(){
        System.out.println("인스턴스를 생성했습니다.");
    }

    //getInstance() 메서드를 통해 항상 동일한 인스턴스를 반환
    public static IDCardFactoryPGR1 getInstance(){
        return s;
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
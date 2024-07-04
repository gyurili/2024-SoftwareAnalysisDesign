package ch04.A2.idcard;


import ch04.A2.framework.Factory;
import ch04.A2.framework.Product;

public class IDCardFactory extends Factory {
    private int serial = 100;
    //key(이름)과 value(신분증 객체)로 관리 => hashMap, hashTable ..

    protected synchronized Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}

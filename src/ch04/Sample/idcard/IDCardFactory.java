package ch04.Sample.idcard;

import ch04.Sample.framework.Factory;
import ch04.Sample.framework.Product;

public class IDCardFactory extends Factory {
    //key(이름)과 value(신분증 객체)로 관리 -> Hashmap, 
    
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}

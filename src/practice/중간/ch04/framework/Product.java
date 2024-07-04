package practice.ch04.framework;

public abstract class Product {

    public abstract void use(); //틀 정의
    
    public Product(){ 
        System.out.println("Product 생성자가 호출되었습니다.");
    }; 
}

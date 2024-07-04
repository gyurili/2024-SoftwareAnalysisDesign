package hw.ch05.framework;

public abstract class Product {

    public abstract void use();
    
    public Product(){ 
        System.out.println("Product 생성자가 호출되었습니다.");
    }; 
}

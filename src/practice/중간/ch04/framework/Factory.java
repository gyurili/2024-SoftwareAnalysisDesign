package practice.ch04.framework;

//일반적인 공장
public abstract class Factory {
    //큰 흐름(생산 과정) 결정 -> Template method
    public final Product create(String owner){
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }


    //구체적인 생산과 등록은 하위 클래스에서 결정함
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);

}

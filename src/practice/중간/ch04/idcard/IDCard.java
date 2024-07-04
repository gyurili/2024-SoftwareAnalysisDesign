package practice.ch04.idcard;

import practice.ch04.framework.Product;

public class IDCard extends Product {
    private String owner;

    public IDCard(String owner) { //명시적 생성자
        //부모의 인자없는 생성자가 자동으로 호출됨 => Product 생성자가 호출되었습니다.
        //super(owner);
        System.out.println(owner + "의 카드를 만듭니다.");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다."); //this: 현재 id카드 객체
    }

    @Override
    public String toString() {
        return "[IDCard:" + owner + "]";
    }

    public String getOwner() {
        return owner;
    }
}

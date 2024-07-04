package practice.ch02.sample1;

//vender class (다른 회사에서 제공하는 클래스)
//Adaptee
public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() { //문자열 앞 뒤에 ( ) 붙이기
        System.out.println("(" + string + ")");
    }

    public void showWithAster() { //문자열 앞 뒤에 ** 붙이기
        System.out.println("***" + string + "***");
    }
}

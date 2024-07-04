package practice.ch02.sample1;

public class Main {
    public static void main(String[] args) {

        //어댑터를 이용하지 않음 (Banner.java)
        Banner b = new Banner("Hello 1");
        b.showWithParen();
        b.showWithAster();

        //Print.java -> PrintBanner.java(어댑터) -> Banner.java
        Print p = new PrintBanner("Hello 2");
        p.printWeak();
        p.printStrong();
    }
}
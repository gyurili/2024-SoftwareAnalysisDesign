package practice.ch02.sample2;

//어댑터
public class PrintBanner extends Print {
    Banner banner; //가져오기

    public PrintBanner(String string) {
        this.banner = new Banner(string); //(셤)
    }

    @Override
    ////Print.java -> PrintBanner.java(어댑터) <- Banner.java
    public void printWeak() {
        //banner 일을 시켜야 함(위임)
        banner.showWithParen(); //(셤)
    }

    @Override
    public void printStrong() {
        banner.showWithAster(); //(셤)
    }
}

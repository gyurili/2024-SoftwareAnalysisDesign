package practice.ch02.sample1;

//상속을 이용한 어댑터
//Banner 상속받기, Print 구현할 것! 선언
public class PrintBanner extends Banner implements Print { 
    
    public PrintBanner(String string) {
        super(string); //부모 생성자 호출
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }

}
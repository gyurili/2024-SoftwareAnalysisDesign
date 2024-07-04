package ch17.Sample;

public class Main {
    public static void main(String[] args) {
        //관찰 대상
        NumberGenerator generator = new RandomNumberGenerator();

        //관찰자들
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();

        //관찰자를 관찰 대상에 등록
        generator.addObserver(observer1);
        generator.addObserver(observer2);

        //관찰 대상에게 상태 변화를 실행하도록 함
        generator.execute();
    }
}

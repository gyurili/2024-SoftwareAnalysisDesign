package hw.ch17;

public class Main {
    public static void main(String[] args) {
        //관찰 대상
        NumberGenerator png = new PrimeNumberGenerator();

        //관찰자들
        Observer o1 = new DigitObserver();
        Observer o2 = new GraphObserver();
        Observer o3 = new NamePrintObserver();

        //관찰자를 관찰 대상에 등록
        png.addObserver(o1);
        png.addObserver(o2);
        png.addObserver(o3);

        //관찰 대상에게 상태 변화를 실행하도록 함
        // 난수가 발생될 때마다 관찰자들은 각자의 방식대로 수를 표시
        png.execute();
    }
}

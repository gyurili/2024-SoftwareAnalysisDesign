package practice.ch17;

public class Main {
    public static void main(String[] args) {
        //관찰 대상
        NumberGenerator ng1 = new RandomNumberGenerator();

        //관찰자들
        Observer o1 = new DigitObserver();
        Observer o2 = new GraphObserver();

        //관찰자를 관찰 대상에 등록
        ng1.addObserver(o1);
        ng1.addObserver(o2);

        //관찰 대상에게 상태 변화를 실행하도록 함
        // 난수가 발생될 때마다 관찰자들은 각자의 방식대로 수를 표시
        ng1.execute();
    }
}

package hw.ch17;

//구체적인 관찰자 1
public class DigitObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) { //수를 얻고
        // 관찰자가 통지 받아서 하는 일
        System.out.println("DigitObserver:" + generator.getNumber()); //화면에 출력
        
        try {
            Thread.sleep(100); //출력 스피드를 늦춤
        } catch (InterruptedException e) {
        }
    }
}

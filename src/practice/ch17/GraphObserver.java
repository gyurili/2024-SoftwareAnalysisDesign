package practice.ch17;

// 구체적인 관찰자 2 (값을 그래프로 표시)
public class GraphObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        System.out.print("GraphObserver:");

        int count = generator.getNumber();

        for (int i = 0; i < count; i++) {
            System.out.print("*"); //관찰한 수만큼 * 출력 (그래프로 표시)
        }
        System.out.println("");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}

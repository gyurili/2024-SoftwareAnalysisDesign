package practice.ch17;

import java.util.Random;

// 구체적인 관찰 대상자 (랜덤하게 수를 생성)
// NumberGenerator를 상속 받아서 추상 메소드 구현
public class RandomNumberGenerator extends NumberGenerator {

    private Random random = new Random(); 	// 난수 생성기 
    private int number;                   	// 현재 수 (상태)

    // 수를 취득한다 
    @Override
    public int getNumber() {
        return number;
    }

    // 수를 생성한다 
    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(50); // 0~49 사이의 정수 난수 생성 => 그때마다 notifyObservers를 호출하여 관찰자에게 통지
            notifyObservers();
        }
    }
}

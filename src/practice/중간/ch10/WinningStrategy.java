package practice.ch10;

import java.util.Random;

public class WinningStrategy implements Strategy {
    private Random random; //난수 생성기
    private boolean won = false; //직전 승부 (자동으로 false가 설정됨)
    private Hand prevHand; //직전에 내민 손

    public WinningStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() { //가위바위보 전략의 핵심
        if (!won) { //직전에 졌으면..
            prevHand = Hand.getHand(random.nextInt(3)); //새로운 손을 이용
        }
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        int count = 0; //로컬 변수 => 초기화가 자동으로 되지 않음. = 0 직접 해줘야 함
        won = win;
    }
}

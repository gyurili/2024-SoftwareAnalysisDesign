package hw.ch17;

import java.util.Random;

public class PrimeNumberGenerator extends NumberGenerator {

    private Random random = new Random();   // 난수 생성기
    private int number;                     // 현재 수 (상태)

    // 수를 취득한다
    @Override
    public int getNumber() {
        return number;
    }

    // 수를 생성한다
    @Override
    public void execute() {
        for (int i = 1; i <= 100; i++) { // 숫자 100개 만들기 (수정)
            number = random.nextInt(100) + 1; // 숫자의 범위는 1부터 100 (수정)
            if (isPrimeNumber(number)) {      // 생성된 숫자가 소수이면 (추가)
                notifyObservers();            // 관찰자에게 통지 (추가)
            }
        }
    }

    // 소수인지 검사 (추가)
    private boolean isPrimeNumber(int num) {
        if (num <= 1) { // 1 이하는 소수가 아님
            return false;
        } 
        for (int i = 2 ; i < num ; i++) { // 나누어 떨어지지면 소수가 아님
            if (num % i == 0){
                return false;
            } 
        }
        return true; // 소수이면 true 반환
    }
}

package practice.ch10;

import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue = 0;
    private int currentHandValue = 0;
    private int[][] history = {
        { 1, 1, 1, },
        { 1, 1, 1, },
        { 1, 1, 1, },
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue)); //0~14 사이의 숫자 발생
        int handvalue = 0;
        if (bet < history[currentHandValue][0]) {
            handvalue = 0;
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) { //(셤)
            handvalue = 1;
        } else {
            handvalue = 2;
        }
        prevHandValue = currentHandValue;
        currentHandValue = handvalue;
        return Hand.getHand(handvalue);
    }

    private int getSum(int handvalue) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += history[handvalue][i]; //행을 더함 //(셤)
        }
        return sum;
    }

    @Override
    public void study(boolean win) {
        if (win) {  //이겼으면 ..
            history[prevHandValue][currentHandValue]++; //해당 칸에 1을 더함
        } else { //졌으면 ..
            history[prevHandValue][(currentHandValue + 1) % 3]++; //다른 칸에 1을 더함
            history[prevHandValue][(currentHandValue + 2) % 3]++; //다른 칸에 1을 더함
        }
    }
}

package practice.ch10;

public class Main {
    public static void main(String[] args) {
        
        //player1 = 전략 1 채택
        Player p1 = new Player("KIM", new ProbStrategy(100)); 
        //player2 = 전략 2 채택
        Player p2 = new Player("LEE", new WinningStrategy(200)); 

        Hand h1 = p1.nextHand();
        Hand h2 = p2.nextHand();

        if (h1.isStrongerThan(h2)){
            p1.win();
            p2.lose();
        }
        else if(h1.isWeakerThan(h2)){
            p1.lose();
            p2.win();
        }
        else {
            p1.even();
            p2.even();
        }

        System.out.println(p1.toString());
        System.out.println(p2);

        //전략을 동적으로 교체
        p1.setStrategy(new WinningStrategy(300));
    }
}

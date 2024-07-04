package practice.ch12;

public class Main {
    public static void main(String[] args) {
        Display sd1 = new StringDisplay("Hello");
        sd1.show();

        Display sb1 = new SideBorder(sd1, '|');
        sb1.show();

        Display fb1 = new FullBorder(sb1);
        fb1.show();
    }
}

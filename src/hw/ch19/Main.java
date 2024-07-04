package hw.ch19;

public class Main {
    public static void main(String[] args) {

        SafeFrame frame = new SafeFrame("State Sample (20220526 박규리)");

        int hour = 15; // 최초 시간 = 15:00

        while (true) {
            frame.setClock(hour % 24); // 24시간제로 설정
            hour++; // 시간 증가

            if (hour == 25) { // 15:00에서 24:00까지 반복한 뒤, 다시 15:00으로 설정
                hour = 15;
            }

            try {
                Thread.sleep(2000); // 2초당 1시간이 흘러가도록
            } catch (InterruptedException e) {}
        }
    }
}

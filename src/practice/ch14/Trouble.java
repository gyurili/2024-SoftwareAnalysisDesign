package practice.ch14;


// 트러블을 나타내는 클래스
public class Trouble {
    private int number; // 트러블 번호 

    // 트러블 생성 
    public Trouble(int number) {
        this.number = number;
    }

    // 트러블 번호를 얻는다 (트러블 번호 반환)
    public int getNumber() {
        return number;
    }

    // 트러블의 문자열 표현
    @Override
    public String toString() {
        return "[Trouble " + number + "]";
    }
}

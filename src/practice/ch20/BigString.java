package practice.ch20;

// Bigchar을 모아서 만든 '큰 문자열'을 나타냄
public class BigString {
    // '큰 문자'의 배열
    private BigChar[] bigchars; // 배열 선언 (타입만 알려줌)

    // 생성자 
    public BigString(String string) {
        BigCharFactory factory = BigCharFactory.getInstance();

        bigchars = new BigChar[string.length()]; // 배열 생성[원소 개수] (중요)

        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = factory.getBigChar(string.charAt(i)); // 공유가 실현됨
        }
    }

    // 표시
    public void print() {
        for (BigChar bc: bigchars) {
            bc.print();
        }
    }
}

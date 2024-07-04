package hw.ch07;

// 하나의 문서를 만드는 클래스
public class Director {
    private Builder builder;

    // 생성자 
    public Director(Builder builder) {
        // 방법 1) 의존성 주입(Dependency Injection)
        this.builder = builder; // 이용할 빌더를 클라이언트가 결정한다 => 이용할(의존할) 빌더를 외부에서 주입
        // this.builder = new TextBuilder();  // 방법 2) 이용할 빌더를 Director가 직접 생성하는 것도 가능!
    }

    // 문서를 만드는 메소드 (Builder의 메소드들을 사용하여 문서를 만듦)
    public void construct() {
        builder.makeTitle("Greeting~");
        builder.makeString("general greeting");
        builder.makeItems(new String[]{
            "How are you?",
            "Hello.",
            "Hi.",
        });
        builder.makeString("Timely greeting");
        builder.makeItems(new String[]{
            "Good morning.",
            "Good afternoon.",
            "Good evening.",
        });
        builder.close();
    }
}

package practice.ch05;

public class Singleton2 {

    private static Singleton2 s = null; //(셤)

    private Singleton2(){
        System.out.println("Singleton2 객체를 생성했습니다.");
    }

    public static Singleton2 getInstance(){
        // getInstance가 처음 호출되었다면 
        // null = 객체 생성 여부 판단하는 변수
        if ( s == null ){  //(셤)
            s = new Singleton2(); //(셤)
        }

        return s; //getInstance 두번째 실행부터는 리턴 호출
    }
}

package practice.ch05;

public class Main2 {
    public static void main(String[] args) {

        Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = Singleton2.getInstance();

        System.out.println(s1);
        System.out.println(s2);

        if (s1 == s2){ 
            System.out.println("두 인스턴스가 같습니다.");
        }
        else {
            System.out.println("두 인스턴스가 다릅니다.");
        }
        
    }
    
}

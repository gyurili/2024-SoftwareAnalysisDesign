package practice.ch05;

public class Main {
    public static void main(String[] args) {
        
        Singleton s1 = Singleton.getInstance(); 
        Singleton s2 = Singleton.getInstance();

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

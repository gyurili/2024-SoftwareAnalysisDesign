package practice.ch11;

public class Main {
    public static void main(String[] args) {
        //File 객체
        Entry f1 = new File("a.txt", 100);

        System.out.println(f1.getName());
        System.out.println(f1.getSize());

        //오버로딩 활용
        f1.printList();
        f1.printList("c:/docs");

        Entry f2 = new File("b.txt", 200);

        //Directory 객체
        Entry d1 = new Directory("bin");

        //다운캐스팅: 부모 타입 -> 자식 타입으로 형변환
        ((Directory)d1).add(f1); 
        ((Directory)d1).add(f2);

        System.out.println(d1.getSize());
        System.out.println("===========");

        //자기 출력 + 자기 안에 내용물 출력 
        //디렉토리가 있으면 디렉토리 출력 => 디렉토리 내용물 출력
        d1.printList(); 
        
        System.out.println("===========");

        Directory root = new Directory("root");
        root.add(d1); //d1 = bin => root 밑에 /bin이 달리게 됨
        root.add(new File("root.txt", 300));
        
        root.printList();
        System.out.println("===========");

        System.out.println(root.getSize());
    }
}

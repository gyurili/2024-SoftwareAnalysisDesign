package practice.ch20;

public class Main {
    public static void main(String[] args) {

        //객체 2개 생성 => 낭비
        BigChar bc1 = new BigChar('1');
        bc1.print();

        BigChar bc2 = new BigChar('1');
        bc2.print();

        System.out.println(bc1); //둘이 주소가 다름!
        System.out.println(bc2); //둘이 주소가 다름!

        //공장을 통해서 생성 => 공유
        BigCharFactory f1 = BigCharFactory.getInstance();

        BigChar bc3 = f1.getBigChar('2');
        bc3.print();

        BigChar bc4 = f1.getBigChar('2');
        bc4.print();

        System.out.println(bc3); //둘이 주소가 같음!
        System.out.println(bc4); //둘이 주소가 같음!

        //명령형 인자를 체크해서 일을 수행
        if(args.length == 0){ //실행 시 인자가 없으면
            System.out.println("사용법: java Main 숫자들");
        }
        else if (args.length == 1){ //실행 시 인자가 1개면
            // for(){
            //     f1.getBigChar(args[0].charAt(i));
            // }
            BigString bs = new BigString(args[0]);
            bs.print();
        }
    }
}

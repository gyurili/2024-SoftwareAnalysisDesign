package hw.ch07;


// 클라이언트(의뢰인) 역할
public class Main {
    public static void main(String[] args) {

        // (수정) XMLBuilder 이용하여 XML 파일 생성
        XMLBuilder xb1 = new XMLBuilder();
        Director d1 = new Director(xb1);
        d1.construct();
        System.out.println(xb1.getXMLResult());

    }
}

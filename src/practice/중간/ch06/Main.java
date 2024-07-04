package practice.ch06;

import practice.ch06.framework.Manager;
import practice.ch06.framework.Product;

public class Main {
    public static void main(String[] args) {

        // 클래스 이름을 이용해서 객체 생성
        Product pen1 = new UnderlinePen('-');
        pen1.use("duksung1-1");

        Product mb1 = new MessageBox('*');
        mb1.use("duksung1-2");

        System.out.println("=================================");

        //자기 복제해서 객체 생성(클래스 이름이 사용 안 됨)
        Product pen2 = pen1.createCopy();
        pen2.use("duksung2-1");

        Product mb2 = mb1.createCopy();
        mb2.use("duksung2-2");

        System.out.println("=================================");

        //Manager를 이용해서 객체 생성
        //(1) 매니저 생성
        Manager manager = new Manager();

        //(2) 프러덕트 생성
        Product upen = new UnderlinePen('-');
        Product mbox = new MessageBox('*');

        //(3) 프러덕트들을 매니저에 등록
        manager.register("strong message", upen);
        manager.register("warning box", mbox);

        //(4) 매니저를 통해 객체 생성 및 사용
        Product sm = manager.create("strong message");
        sm.use("strong duksung");

        Product wb = manager.create("warning box");
        wb.use("warning duksung");
    }
}

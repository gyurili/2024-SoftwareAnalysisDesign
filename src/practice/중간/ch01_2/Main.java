package practice.ch01_2;

import java.util.Iterator;;

public class Main {
    public static void main(String[] args) {

        Book b1 = new Book("duksung1");
        Book b2 = new Book("duksung2");
        Book b3 = new Book("duksung3");
        System.out.println(b1.getName());

        BookShelf bs1 = new BookShelf(10); //책 10권 꽂는 책꽂이 만들기

        //책 꽂기
        bs1.appendBook(b1);
        bs1.appendBook(b2);
        bs1.appendBook(b3);

        //책 한 권씩 꺼내와서 이름 출력하기
        System.out.println(bs1.getBookAt(0).getName());
        System.out.println(bs1.getBookAt(1).getName());
        System.out.println(bs1.getBookAt(2).getName());

        //for 이용
        for (int i = 0; i < bs1.getLength(); i++) {
            System.out.println(bs1.getBookAt(i).getName());
        }
        
        //iterator 패턴
        //1. 책꽂이한테 책꽂이 반복자를 요청해서 얻음
        Iterator<Book> it = bs1.iterator();

        //2. 책꽂이 반복자를 이용해서 책을 한 권씩 꺼내옴
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book.getName());
        }

        //확장된 for문
        for (Book book : bs1) {
            System.out.println(book.getName());
        }

        //책꽂이 만든 개발자, 책꽂이 이용하는 이용자
    }
}

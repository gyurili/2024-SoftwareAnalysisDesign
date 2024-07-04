package hw.ch01;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        System.out.println("학번: 20220526, 이름: 박규리");

        //책 추가
        BookShelf bookShelf = new BookShelf(6);
        bookShelf.appendBook(new Book("자료구조론", "박우창"));
        bookShelf.appendBook(new Book("소프트웨어분석설계", "최승훈"));
        bookShelf.appendBook(new Book("프로그래머수학", "이주영"));
        bookShelf.appendBook(new Book("컴퓨터동작원리", "유견아"));
        bookShelf.appendBook(new Book("컴퓨터그래픽스", "이경미"));
        bookShelf.appendBook(new Book("파이썬프로그래밍", "미상"));
        
        Iterator<Book> it = bookShelf.iterator(); //Iterator<Book> 객체를 생성

        while (it.hasNext()) { //책장을 순회하여 책 이름과 저자를 출력
            Book book = it.next();
            System.out.println(book.getName() + "/" + book.getauthor());
        }
        System.out.println();
    }
}

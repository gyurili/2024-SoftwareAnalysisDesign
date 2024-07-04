package practice.ch01;

import java.util.Iterator;

public class BookShelf implements Iterable<Book> { //(셤)
    private Book[] books; //Book 배열 선언
    private int last = 0;

    //생성자
    public BookShelf(int maxsize) {
        this.books = new Book[maxsize]; //Book 배열 생성
    }

    //책 한 권 꺼내오기
    public Book getBookAt(int index){
        return books[index];
    }

    //책 한 권 꽂기
    public void appendBook(Book book){
        books[last] = book;
        last++; //한 칸 오른쪽으로 이동
    }

    //책 개수 얻어오기
    public int getLength() {
        return last;
    }
    
    @Override
    //책꽂이 반복자를 리턴하는 매소드
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this); //(셤)
    }
}

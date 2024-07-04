package hw.ch01;

import java.util.Iterator;

public class BookShelf implements Iterable<Book> {  //(셤)
    private Book[] books; //책 저장 배열
    private int last = 0; //현재 저장된 책의 수

    public BookShelf(int maxsize) { //책장
        this.books = new Book[maxsize];
    }

    public Book getBookAt(int index) { //특정 위치 책 반환
        return books[index];
    }

    public void appendBook(Book book) { //책장에 책 추가
        this.books[last] = book;
        last++;
    }

    public int getLength() { //책장에 저장된 책의 수 반환
        return last;
    }

    @Override
    public Iterator<Book> iterator() { //책 역순으로 접근
        return new BookShelfIteratorBackward(this);
    }
}

package practice.ch01_2;

import java.util.ArrayList;
import java.util.Iterator;

public class BookShelf implements Iterable<Book> {
    private ArrayList<Book> books;

    //생성자
    public BookShelf(int maxsize) {
        this.books = new ArrayList<Book>();
    }

    //책 한 권 꺼내오기
    public Book getBookAt(int index){
        return books.get(index);
    }

    //책 한 권 꽂기
    public void appendBook(Book book){
        books.add(book);
    }

    //책 개수 얻어오기
    public int getLength() {
        return books.size();
    }
    
    @Override
    //책꽂이 반복자를 리턴하는 매소드
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}

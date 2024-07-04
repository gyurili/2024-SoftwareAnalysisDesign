package hw.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfIteratorBackward implements Iterator<Book> {
    private BookShelf bookShelf;
    private int index;

    //생성자
    public BookShelfIteratorBackward(BookShelf bookShelf) { 
        this.bookShelf = bookShelf;
        //마지막 위치로 설정 (인덱스 가장 마지막부터 꺼내기)
        this.index = bookShelf.getLength() -1;
    }

    @Override
    public boolean hasNext() {
        //꺼내올 책이 더 있으면 ture (0보다 크면 책을 가져옴)
        if (index >= 0) { 
            return true; //다음 책이 있음
        } else {
            return false; //다음 책이 없음
        }
    }
    
    @Override
    public Book next() { 
        if (!hasNext()) { //다음 책이 없으면 예외를 던짐
            throw new NoSuchElementException();
        }
        //현재 index에 해당하는 책을 BookShelf에서 가져옴
        Book book = bookShelf.getBookAt(index); //(셤)
        index--; //index 위치를 한 칸 앞으로 옮김
        return book; //현재 index에 해당하는 책 객체를 반환
    }
}

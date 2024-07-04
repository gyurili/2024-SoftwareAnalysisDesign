package hw.ch01;

public class Book {
    private String name; //책 이름
    private String author; //저자 이름

    public Book(String name, String author) { //Book 생성자
        this.name = name;
        this.author = author;
    }

    //책 이름 반환
    public String getName() {
        return name;
    }

    //저자 이름 반환
    public String getauthor() {
        return author;
    }
}

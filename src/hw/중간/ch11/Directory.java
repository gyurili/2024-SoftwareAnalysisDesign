package hw.ch11;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry { 
    
    private String name;
    private String date; //변수 추가
    private String author; //변수 추가

    private List<Entry> directory = new ArrayList<>(); 

    //추가한 변수에 맞게 생성자 수정
    public Directory(String name, String date, String author) {
        this.name = name;
        this.date = date;
        this.author = author;
    }

    //추가
    public int getCount(){
        int count = 0;
        for (Entry entry: directory) {
            count += entry.getCount();
        }
        return count;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0; //사이즈 초기화
        for (Entry entry: directory) {
            size += entry.getSize(); //재귀적 호출
        }
        return size; //현재 디렉토리의 사이즈 반환
    }

    @Override
    protected void printList(String prefix) {
        
        System.out.println(prefix + "/" + this.getName() + " (" + this.getSize() + ") [" + this.date + "] [" + this.getCount() + "개] [" + this.author + "]");

        for (Entry entry: directory) {
            entry.printList(prefix + "/" + this.getName()); //재귀적 호출
        }
    }

    // 디렉터리 엔트리를 디렉터리에 추가한다
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }
}

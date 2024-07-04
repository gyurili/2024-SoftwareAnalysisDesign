package practice.ch11;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry { //그릇 역할
    
    private String name;
    private List<Entry> directory = new ArrayList<>(); //내용물을 담아둠

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0; //사이즈 초기화
        for (Entry entry: directory) {
            size += entry.getSize(); //재귀적 호출 //(셤)
        }
        return size; //현재 디렉토리의 사이즈 반환
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);

        for (Entry entry: directory) {
            entry.printList(prefix + "/" + name); //재귀적 호출
        }
    }

    // 디렉터리 엔트리를 디렉터리에 추가한다
    public Entry add(Entry entry) { 
        directory.add(entry); 
        return this;
    }
}

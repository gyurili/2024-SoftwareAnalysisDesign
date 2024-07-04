package hw.ch11;

//내용물을 나타냄 (추상 클래스 -> File, Directory의 상위 클래스)
public abstract class Entry { 
    // 이름을 얻는다
    public abstract String getName();

    // 크기를 얻는다 
    public abstract int getSize();

    //추가: 파일 개수를 얻는다
    public abstract int getCount();

    //메소드 오버로딩 (인수에 따라 다른 메소드가 실행됨)
    // 1. 목록을 표시한다
    public void printList() {
        printList("");
    }

    // 2. prefix를 앞에 붙여서 목록을 표시한다 (추상 메소드)
    protected abstract void printList(String prefix);

    // 문자열 표시 
    @Override
    public String toString() { //템플릿 메소드
        return getName() + " (" + getSize() + ")";
    }
}

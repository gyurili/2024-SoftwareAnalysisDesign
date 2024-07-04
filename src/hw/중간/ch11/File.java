package hw.ch11;

public class File extends Entry {
    private String name;
    private String date; //변수 추가
    private int size;
    private String author; //변수 추가
    
    //추가한 변수에 맞게 생성자 수정
    public File(String name, String date, int size, String author) { 
        this.name = name;
        this.date = date;
        this.size = size;
        this.author = author;
    }

    //추가
    public int getCount(){
        return 1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) { //출력 내용 추가
        System.out.println(prefix + "/" + this.getName() + " (" + this.getSize() + ") [" + this.date + "] [" + getCount() + "개] [" + this.author + "]");
    }
}

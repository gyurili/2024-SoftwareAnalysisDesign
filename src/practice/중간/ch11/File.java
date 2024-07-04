package practice.ch11;

public class File extends Entry {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
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
    //prefix: 경로를 제공하는 역할
    protected void printList(String prefix) { 
        System.out.println(prefix + "/" + this);
    }
}

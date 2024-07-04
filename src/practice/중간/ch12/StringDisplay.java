package practice.ch12;

public class StringDisplay extends Display {
    private String string; // 표시 문자열 

    public StringDisplay(String string) {
        this.string = string;
    }

    @Override
    public int getColumns() {
        return string.length();
    }

    @Override
    public int getRows() {
        return 1; // 행수는 1
    }

    @Override
    public String getRowText(int row) { 
        //한 줄 문자열 출력 = 행 번호는 무조건 0만 있어야 함
        if (row != 0) {
            throw new IndexOutOfBoundsException();
        }
        return string;
    }
}

package hw.ch12;

public class MultiSideBorder extends Border {
    private char borderChar; //장식문자
    private int num; //장식문자를 반복할 수

    //생성자
    public MultiSideBorder(Display display, char ch, int num) {
        super(display);
        this.borderChar = ch;
        this.num = num;
    }

    //num만큼 반복해서 장식문자열 반환 (*** 내용 *** 생성)
    private String makeLine(char ch, int count) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < count; i++) {
            line.append(ch);
        }
        return line.toString();
    }

    //가로 길이 반환
    @Override
    public int getColumns() {
        return num + display.getColumns() + num; //num만큼 양 옆을 더함
    }

    //세로 길이 반환
    @Override
    public int getRows() {
        return display.getRows();
    }

    //행의 내용 반환
    @Override
    public String getRowText(int row) {
        //장식문자 + 해당 행의 내용 + 장식문자
        return makeLine(borderChar, num) + display.getRowText(row) + makeLine(borderChar, num);
    }
}


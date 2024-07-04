package ch12.A2;

import java.util.ArrayList;
import java.util.List;

public class MultiStringDisplay extends Display {
    // 표시 문자열 저장 장소
    private List<String> body = new ArrayList<>();
    // 표시 문자열 최대 문자 수 
    private int columns = 0;

    // 문자열 추가 
    public void add(String msg) {
        body.add(msg);
        if (columns < msg.length()) { //더 긴 문자열이 들어오면 ..
            // 최대 문자 수 갱신
            columns = msg.length();
        }
        updatePadding();
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public int getRows() {
        return body.size();
    }

    @Override
    public String getRowText(int row) {
        return body.get(row);
    }

    // 표시 문자열 오른쪽 끝에 채울 공백을 필요에 따라 늘린다
    private void updatePadding() {
        for (int row = 0; row < body.size(); row++) {
            String line = body.get(row); // 리스트로부터 문자열 한 개를 얻음
            int padding = columns - line.length(); // 필요한 빈 칸 수를 계산
            if (padding > 0) { // 현재 문자열이 더 짧으면
                body.set(row, line + spaces(padding)); //뒤에 빈 칸을 붙여줌
            }
        }
    }

    // count 수만큼의 공백을 만든다 
    private String spaces(int count) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < count; i++) {
            spaces.append(' ');
        }
        return spaces.toString();
    }
}

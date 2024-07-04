package practice.ch20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// '큰 문자'를 나타냄 (파일에서 큰 문자 텍스트 읽어서 print)
public class BigChar {
    // 문자의 이름 
    private char charname;  // '1'
    // 큰 문자를 표현하는 문자열('#' '.' '\n'으로 이루어진 열)
    private String fontdata; //file의 내용을 저장하는 문자열

    // 생성자 
    public BigChar(char charname) {
        this.charname = charname;
        try {
            String filename = "big" + charname + ".txt"; // "Big1.txt" 같은 파일명을 가짐
            StringBuilder sb = new StringBuilder();
            for (String line: Files.readAllLines(Path.of(filename))) {
                sb.append(line);
                sb.append("\n");
            }
            this.fontdata = sb.toString();
        } catch (IOException e) {
            this.fontdata = charname + "?"; // "1?"
        }
    }

    // 큰 문자를 표시한다
    public void print() {
        System.out.print(fontdata);
    }
}

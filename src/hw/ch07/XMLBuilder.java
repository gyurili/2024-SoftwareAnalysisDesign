package hw.ch07;

import java.io.*;

// 구체적인 건축자 
// public class XMLBuilder extends Builder {
public class XMLBuilder implements Builder {

    private String filename = "untitled.xml";
    private StringBuilder xb = new StringBuilder();

    // (수정) 조건에 맞게 출력하도록 모든 함수 수정
    @Override
    public void makeTitle(String title) {
        filename = title + ".xml";
        xb.append("<document>\n");
        xb.append("<title>");
        xb.append(title);
        xb.append("</title>\n");
    }

    @Override
    public void makeString(String str) {
        xb.append("<string>");
        xb.append(str);
        xb.append("</string>\n\n");
    }

    @Override
    public void makeItems(String[] items) {
        xb.append("<items>\n");
        for (String s: items) {
            xb.append("    <item>");
            xb.append(s);
            xb.append("</item>\n");
        }
        xb.append("</items>\n\n");
    }

    @Override
    public void close() {
        xb.append("</document>");
        try {
            Writer writer = new FileWriter(filename);
            writer.write(xb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getXMLResult() { // 완성된 문서를 얻을 때 호출되는 메소드 
        return filename;
    }
}

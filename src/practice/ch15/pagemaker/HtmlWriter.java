package practice.ch15.pagemaker;

import java.io.Writer;
import java.io.IOException;

// html 파일을 작성하는 클래스
public class HtmlWriter {
    private Writer writer;

    public HtmlWriter(Writer writer) {  // 중요! 의존성 주입
        this.writer = writer;
    }

    // 타이틀 출력 
    public void title(String title) throws IOException {
        /* 버전 1
        writer.write("<!DOCTYPE html>");
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>" + title + "</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("\n");
        writer.write("<h1>" + title + "</h1>");
        writer.write("\n");
        */


        // 버전 2 (텍스트 블록)
        String html =
        """
            <!DOCTYPE html>
            <html>
            <head>
            <title> %s </title>
            </head>
            <body>
            <h1> %s </h1>
        """.formatted(title, title);
        writer.write(html); 
    
    }

    // 단락 출력
    public void paragraph(String msg) throws IOException {
        writer.write("<p>" + msg + "</p>");
        writer.write("\n");
    }

    // 링크 출력
    public void link(String href, String caption) throws IOException {
        paragraph("<a href=\"" + href + "\">" + caption + "</a>"); // \" 주의!
    }

    // 이메일 주소 출력 
    public void mailto(String mailaddr, String username) throws IOException {
        link("mailto:" + mailaddr, username);
    }

    // HTML 닫기 
    public void close() throws IOException {
        writer.write("</body>");
        writer.write("</html>");
        writer.write("\n");
        writer.close();
    }
}

package hw.ch15.pagemaker;

import java.io.Writer;
import java.io.IOException;

public class HtmlWriter {
    private Writer writer;

    public HtmlWriter(Writer writer) { 
        this.writer = writer;
    }

    // 타이틀 출력 
    public void title(String title) throws IOException {
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
        writer.write("    <p>" + msg + "</p>");
        writer.write("\n");
    }

    // 링크 출력
    public void link(String href, String caption) throws IOException {
        paragraph("<a href=\"" + href + "\">" + caption + "</a>"); // \" 주의!
    }

    // HTML 닫기 
    public void close() throws IOException {
        writer.write("</body>");
        writer.write("\n");
        writer.write("</html>");
        writer.write("\n");
        writer.close();
    }
}

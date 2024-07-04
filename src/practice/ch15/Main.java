package practice.ch15;

import practice.ch15.pagemaker.PageMaker;

// 클라이언트 (Facade 이용)
public class Main {
    public static void main(String[] args) {
        /* 
        // 버전 1 (구식)
        HtmlWriter writer = new HtmlWriter(new FileWriter("Welcome.html"));
        writer.title();
        writer.link();
        writer.paragraph(null);
        writer.close();
        */

        // 버전 2 (추천)
        // PageMaker.makeWelcomePage("dojun@example.com", "welcome3.html");
        // PageMaker.makeWelcomePage("love@naver.com", "welcome4.html");

        PageMaker.makeWelcomePage("dojun@example.com", "welcome3.html");
        PageMaker.makeLinkPage("link-page.html");
        System.out.println("link-page.html is created");
    }
}

package practice.ch15.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

// Facade, 이메일 주소로 사용자의 웹페이지를 작성하는 클래스
public class PageMaker {
    private PageMaker() {
    }

    public static void makeWelcomePage(String mailaddr, String filename) {
        
        try {
            // Property 파일에서 정보(사용자 이름)를 얻어옴
            Properties mailprop = Database.getProperties("maildata");
            String username = mailprop.getProperty(mailaddr);

            //웰컴 파일의 내용을 완성
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            
            writer.title(username + "'s web page");
            writer.paragraph("Welcome to " + username + "'s web page!");
            writer.paragraph("Nice to meet you!");

            writer.mailto(mailaddr, username);

            writer.close();
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeLinkPage(String filename) {
        
        try{
            // Property 파일에서 데이터를 얻어옴
            Properties mailprop = Database.getProperties("maildata");

            // 이메일주소, 사용자 이름으로 링크 만들기
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));

            writer.title("LinkPage");

            Set<String> mailaddress = mailprop.stringPropertyNames(); //Property 이름들만 가져와서 집합으로 만듦

            for( String mailaddr : mailaddress){
                writer.mailto( mailaddr, mailprop.getProperty(mailaddr)); // getProperty 값 = username
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

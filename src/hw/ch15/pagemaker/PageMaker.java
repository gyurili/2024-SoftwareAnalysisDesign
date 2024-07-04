package hw.ch15.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

// Facade
public class PageMaker {
    private PageMaker() {
    }    

    // (추가)
    public static void makeUrlPage(String filename){
        try {
            Properties urlprop = Database.getProperties("urldata");

            // 키 값에 맞는 링크 가져오기
            String url1 = urlprop.getProperty("duksung");
            String url2 = urlprop.getProperty("naver");
            String url3 = urlprop.getProperty("google");

            // html 문서 만들기
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("ParkGyuri's URL Page");

            // 링크 추가하기
            writer.link(url1, "duksung");
            writer.link(url2, "naver");
            writer.link(url3, "Google");

            // html 문서 닫기
            writer.close();

            System.out.println(filename + " is created");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


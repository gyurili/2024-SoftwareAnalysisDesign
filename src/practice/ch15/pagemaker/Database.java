package practice.ch15.pagemaker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

// 이메일 주소에서 사용자 이름을 얻는 클래스
public class Database {
    private Database() { }

    // 데이터베이스 이름에서 Properties를 얻는다 
    // 버전 2: try-catch 대신 throws IOException 사용
    public static Properties getProperties(String dbname) throws IOException { 
        String filename = dbname + ".txt";
        Properties prop = new Properties();
        /* 
        // 버전 1
        try{
            prop.load(new FileReader(filename));
        } catch(IOException e){

        }
        */
        // 버전 2
        prop.load(new FileReader(filename)); // 중요!
        return prop;
    }
}

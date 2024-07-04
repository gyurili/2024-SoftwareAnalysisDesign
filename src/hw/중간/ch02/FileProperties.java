package hw.ch02;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

// 상속을 이용한 구현
public class FileProperties extends Properties implements FileIO {

    @Override
    public void readFromFile(String filename) throws IOException {
        load(new FileReader(filename));
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        store(new FileWriter(filename), "written by FileProperties (상속)"); 
    }

    @Override
    public void setValue(String key, String value) {
        setProperty(key, value); 
    }

    @Override
    public String getValue(String key) {
        return getProperty(key, ""); 
    }
}

//어댑터(위임 이용)
// public class FileProperties implements FileIO {
//     //어댑터를 생성
//     Properties property = new Properties();

//     @Override
//     public void readFromFile(String filename) throws IOException {
//         property.load(new FileReader(filename)); //위임
//     }

//     @Override
//     public void writeToFile(String filename) throws IOException {
//         property.store(new FileWriter(filename), "written by FileProperties (위임)");
//     }

//     @Override
//     public void setValue(String key, String value) {
//         property.setProperty(key, value);
//     }

//     @Override
//     public String getValue(String key) {
//         return property.getProperty(key, "");
//     }
// }

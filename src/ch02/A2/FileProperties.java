package ch02.A2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

//어댑터(위임 이용)
public class FileProperties implements FileIO {
    //어댑터를 생성
    Properties property = new Properties();

    @Override
    public void readFromFile(String filename) throws IOException {
        property.load(new FileReader(filename)); //위임
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        property.store(new FileWriter(filename), "written by FileProperties");
    }

    @Override
    public void setValue(String key, String value) {
        property.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return property.getProperty(key, "");
    }
}

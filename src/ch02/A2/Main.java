package ch02.A2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //어댑터 생성
        FileIO f = new FileProperties();

        try {
            f.readFromFile("file.txt"); //읽기

            f.setValue("width", "1024"); //값 수정
            f.setValue("height", "512"); //값 넣기
            f.setValue("depth", "32"); //값 넣기

            f.setValue("name", "PGR");

            f.writeToFile("newfile.txt"); //파일 이름 지정

            System.out.println("newfile.txt is created.");

            System.out.println(f.getValue("name"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

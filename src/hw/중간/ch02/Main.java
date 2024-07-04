package hw.ch02;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("20220526 박규리");

        FileIO f = new FileProperties();
        try {
            f.readFromFile("file.txt");
            f.setValue("Year", "2024");
            f.setValue("bornYear", "2003");
            f.setValue("StudentId", "20220526");
            f.setValue("Name", "ParkGyuri");
            f.setValue("Location", "Seoul");
            f.writeToFile("ParkGyuri.txt");
            System.out.println("ParkGyuri.txt is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

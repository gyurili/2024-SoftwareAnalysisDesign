package hw.ch11;

public class Main {
    public static void main(String[] args) {

        System.out.println("20220526 박규리");

        //객체 생성
        Directory MyDocuments = new Directory("MyDocuments", "20240401", "ParkGyuri");
        File ParkGyuri0 = new File("ParkGyuri0.doc", "20240501", 1000, "ParkGyuri");
        
        Directory MyData = new Directory("MyData", "20240401", "ParkGyuri");
        File ParkGyuri1 = new File("ParkGyuri1.doc", "20240501", 2000, "ParkGyuri");
        File ParkGyuri2 = new File("ParkGyuri2.java", "20240501", 3000, "ParkGyuri");

        Directory MyPictures = new Directory("MyPictures", "20240401", "ParkGyuri");
        File ParkGyuri3 = new File("ParkGyuri3.gif", "20240601", 4000, "ParkGyuri");
        File ParkGyuri4 = new File("ParkGyuri4.jpg", "20240601", 5000, "ParkGyuri");
        File ParkGyuri5 = new File("ParkGyuri5.png", "20240601", 6000, "ParkGyuri");

        //조건에 맞게 트리구조 만들기
        MyDocuments.add(ParkGyuri0);
        MyDocuments.add(MyData);

        MyData.add(ParkGyuri1); 
        MyData.add(ParkGyuri2); 
        MyData.add(MyPictures); 
        
        MyPictures.add(ParkGyuri3); 
        MyPictures.add(ParkGyuri4); 
        MyPictures.add(ParkGyuri5);

        MyDocuments.printList();
    }
}

package hw.ch10;

import java.util.*;

class Main {
    public static void main(String[] args) {
        
        System.out.println("20220526 박규리");

        //Student 객체 5개 생성
        Student s1 = new Student("최승훈", "1", 180);
        Student s2 = new Student("박규리", "2", 175);
        Student s3 = new Student("홍길동", "3", 170);
        Student s4 = new Student("김철수", "4", 165);
        Student s5 = new Student("김영희", "5", 160);

        //Student 리스트 생성
        List<Student> list = Arrays.asList(s1, s2, s3, s4, s5);

        System.out.println("<<오름차순 정렬 결과>>");
        // 키 오름차순 정렬
        list.sort(new ComparatorAscending());
        System.out.println(list);


        System.out.println("<<내림차순 정렬 결과>>");
        // 키 내림차순 정렬
        list.sort(new ComparatorDesending());
        System.out.println(list);
    }
}

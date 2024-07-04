package ch10.Q4;

import java.util.*;

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        //list.sort(): Comparator의 compare()를 호출해서, 양수가 나오면 두 원소의 위치를 바꾼다
        // 사전순으로 작은 순서
        list.sort(new Comparator<String>() { //자동으로 익명 내부 클래스 생성
            public int compare(String a, String b) {
                //실제로 인자 a와 b를 비교하는 코드
                return a.compareTo(b); //크기 비교, 오름차순으로 정렬
                //a가 더 크면 양수를 리턴, b가 더 크면 음수를 리턴, 같으면 0을 리턴
                //a가 더 커서 양수가 리턴되면, a와 b의 위치를 서로 바꿈
                //큰 a가 뒤로 감 => 오름차순
            }
        });
        System.out.println(list);


        // 사전순으로 큰 순서 
        list.sort(new Comparator<String>() { 
            public int compare(String a, String b) {
                return b.compareTo(a); //크기 비교, 내림차순으로 정렬
                //b가 더 크면 양수를 리턴, a가 더 크면 음수를 리턴, 같으면 0을 리턴
                //b가 더 커서 양수가 리턴되면, a와 b의 위치를 서로 바꿈
                //큰 b가 앞으로 옴 감 => 내림차순
            }
        });
        System.out.println(list);
    }
}

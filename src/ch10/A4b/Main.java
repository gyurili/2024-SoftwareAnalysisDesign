package ch10.A4b;

import java.util.*;

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        // 사전순으로 작은 순서
        // Comoarator 인터페이스: compare() 메소드 한 개만 선언되어 있음
        // => Functional interface라고 함
        // Functional interface 대신에 람다 함수를 넣을 수도 있음
        list.sort((a, b) -> a.compareTo(b)); //람다 함수를 넣어줌
        System.out.println(list);

        // 사전식 순으로 큰 순서
        list.sort((a, b) -> b.compareTo(a));
        System.out.println(list);
    }
}

package hw.ch10;

//크기 비교가 가능하도록 하려면 Compareable interface 구현해야 함
public class Student implements Comparable<Student>{
    //속성 선언
    String name;
    String id;
    int height; 

    //생성자
    public Student(String name, String id, int height) { 
        this.name = name;
        this.id = id;
        this.height = height;
    }

    @Override
    public int compareTo(Student s) {
        //현재 학생과 인자로 들어온 학생의 크기(height 기준)를 비교하는 코드 작성
        if (this.height > s.height) { // 현재 student의 키가 더 크면 양수 반환
            return 1;
        }
        else if (this.height < s.height) { // 인자로 들어온 student의 키가 더 크면 음수 반환
            return -1;
        }
        else { // 키가 같으면 0을 반환
            return 0;
        }
    }

    @Override
    public String toString() { //이름, id, 키를 출력
        return "(이름: " + name + ", ID: " + id + ", 키: " + height +")";
    }

}
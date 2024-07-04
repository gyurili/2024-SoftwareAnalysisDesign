package hw.ch10;
import java.util.Comparator;

public class ComparatorDesending implements Comparator<Student>{
    
    @Override
    public int compare(Student s1, Student s2) {
        //키 내림차순 정렬
        return s2.compareTo(s1);
    }
}

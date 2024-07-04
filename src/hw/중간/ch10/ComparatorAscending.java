package hw.ch10; 
import java.util.Comparator;

public class ComparatorAscending implements Comparator<Student>{

    @Override
    public int compare(Student s1, Student s2) { 
        //키 오름차순 정렬
        return s1.compareTo(s2);
    }
    
}

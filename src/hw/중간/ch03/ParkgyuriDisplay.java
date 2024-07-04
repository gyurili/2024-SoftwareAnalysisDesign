package hw.ch03;

public class ParkgyuriDisplay extends AbstractDisplay {

    private String name;  
    private String studentId;  
    private int grade;  

    // 생성자 
    public ParkgyuriDisplay(String name, String studentId, int grade) {
        this.name = name;
        this.studentId = studentId;
        this.grade = grade;
    }

    @Override // ===와 학교 출력
    public void open() {
        printLine();
        System.out.println("덕성여대 컴퓨터공학과");
    }

    @Override //학번, 학년, 이름 출력
    public void print() {
        System.out.println("학번 " + studentId + " / " + grade + "학년" + " / " + name);
    }

    @Override  // ===와 제시문 출력
    public void close() {
        System.out.println("템플릿 메소드 패턴 숙제입니다.");
        printLine();
    }

    // === 출력
    private void printLine() {
        System.out.println("======================");
    }

}

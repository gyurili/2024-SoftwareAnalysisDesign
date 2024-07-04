package practice.ch22;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

import practice.ch22.command.*;
import practice.ch22.drawer.*;

// public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener
public class Main extends JFrame {

    // 그리기 이력 
    private MacroCommand history = new MacroCommand();
    // 도화지
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 삭제 버튼
    private JButton clearButton  = new JButton("clear");
    // 색깔 버튼
    private JButton redButton = new JButton("red");
    private JButton blueButton = new JButton("blue");
    private JButton greenButton = new JButton("green");
    //undo 버튼
    private JButton undoButton  = new JButton("undo");


    public static void main(String[] args) {
        new Main("20220526 박규리:Command Pattern Sample");
    }

    
    // 생성자 
    public Main(String title) {
        super(title);
        
        // GUI 컴포넌트 추가
        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(undoButton);
        buttonBox.add(redButton);
        buttonBox.add(blueButton);
        buttonBox.add(greenButton);

        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);

        mainBox.add(canvas);

        getContentPane().add(mainBox);

        // 리스너 등록

        // clearButton.addActionListener(this);
        clearButton.addActionListener( e -> {
            history.clear();
            // 화면에서도 지움
            canvas.repaint(); // 화면을 지움 => paint()
        });
        
        undoButton.addActionListener(e -> {
            history.undo(); // history에서 마지막 커맨드 객체 삭제
            canvas.repaint(); // history를 다시 그림
        });

        this.addWindowListener(new WindowAdapter() { // 이렇게 수정!
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // canvas.addMouseMotionListener(this);
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                // DrawCommand 객체를 만들어서 history에 추가
                Command cmd = new DrawCommand(canvas, e.getPoint()); //Command cmd = new DrawCommand(canvas, e.getPoint(), color);
                history.append(cmd);

                // DrawCommand 실행 (그리기)
                cmd.execute();
            }
        });

        redButton.addActionListener(e -> { // (이 코드 먼가 시험에 나올 거 같다)
            // ColorCommand 생성해서 히스토리에 추가
            Command cmd = new ColorCommand(canvas, Color.red);
            history.append(cmd); 
            // ColorCommand 실행 (붓의 색깔 바꾸기)
            cmd.execute();
        });

        greenButton.addActionListener(e -> {
            // ColorCommand 생성해서 히스토리에 추가
            Command cmd = new ColorCommand(canvas, Color.green);
            history.append(cmd);
            // ColorCommand 실행
            cmd.execute();
        });

        blueButton.addActionListener(e -> {
            // ColorCommand 생성해서 히스토리에 추가
            Command cmd = new ColorCommand(canvas, Color.blue);
            history.append(cmd);
            // ColorCommand 실행
            cmd.execute();
        });

        // this.addWindowListener(this);

        //히스토리 초기화
        history.append((new ColorCommand(canvas, Color.red)));

        //화면에 보이기
        pack();
        setVisible(true);
        
    }

    /* 
    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println("clear 버튼이 눌러짐");
        history.clear();
        // 화면에서도 지움
        canvas.repaint(); // 화면을 지움 => paint()
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // System.out.println("마우스 드래그 중");
        // DrawCommand 객체를 만들어서 history에 추가
        Command cmd = new DrawCommand(canvas, e.getPoint()); //Command cmd = new DrawCommand(canvas, e.getPoint(), color);
        history.append(cmd);

        // DrawCommand 그리기
        cmd.execute();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // System.out.println("마우스 움직이는 중");
    }
    

    @Override
    public void windowOpened(WindowEvent e) { }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("종료됩니다 ..");
        System.exit(0);
    }
    

    @Override
    public void windowClosed(WindowEvent e) { }
    @Override
    public void windowIconified(WindowEvent e) { }
    @Override
    public void windowDeiconified(WindowEvent e) { }
    @Override
    public void windowActivated(WindowEvent e) { }
    @Override
    public void windowDeactivated(WindowEvent e) { }
    */


    
}

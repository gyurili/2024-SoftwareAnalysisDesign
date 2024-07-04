package hw.ch22;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

import hw.ch22.command.*;
import hw.ch22.drawer.*;

public class Main extends JFrame implements MouseMotionListener, WindowListener {

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
    // undo 버튼
    private JButton undoButton  = new JButton("undo");
    // redo 버튼
    private JButton redoButton  = new JButton("redo"); // 추가


    public static void main(String[] args) {
        new Main("20220526 박규리:Command Pattern Sample");
    }

    
    // 생성자 
    public Main(String title) {
        super(title);

        // GUI 컴포넌트 추가
        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(redButton);
        buttonBox.add(blueButton);
        buttonBox.add(greenButton);
        buttonBox.add(undoButton);
        buttonBox.add(redoButton); // 추가
        

        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);


        // 리스너 추가

        this.addWindowListener(this);

        canvas.addMouseMotionListener(this);

        clearButton.addActionListener(e -> {
            history.clear();
            canvas.init(); // (추가) 클리어 시 빨간색으로 초기화
            // 화면에서도 지움
            canvas.repaint();
        });
        redButton.addActionListener(e -> {
            // ColorCommand 생성해서 히스토리에 추가
            Command cmd = new ColorCommand(canvas, Color.red);
            history.append(cmd);
            // ColorCommand 실행 (붓의 색깔 바꾸기)
            cmd.execute();
        });
        greenButton.addActionListener(e -> {
            Command cmd = new ColorCommand(canvas, Color.green);
            history.append(cmd);
            cmd.execute();
        });
        blueButton.addActionListener(e -> {
            Command cmd = new ColorCommand(canvas, Color.blue);
            history.append(cmd);
            cmd.execute();
        });
        undoButton.addActionListener(e -> {
            history.undo();
            canvas.repaint();
        });
        redoButton.addActionListener(e -> { // 추가
            history.redo();
            canvas.repaint();
        });

        // 처음 시작했을 때 빨간 색으로 설정 (추가)
        canvas.init();

        //화면에 보이기
        pack();
        setVisible(true);
    }
    

    // MouseMotionListener용
    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        // DrawCommand 객체를 만들어서 history에 추가
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        // DrawCommand 실행 (그리기)
        cmd.execute();
    }

    // WindowListener용
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override public void windowOpened(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}

}

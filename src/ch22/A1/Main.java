package ch22.A1;

import ch22.A1.command.*;
import ch22.A1.drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements MouseMotionListener, WindowListener {
    // 그리기 이력 
    private MacroCommand history = new MacroCommand();
    // 그리는 영역 
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 삭제 버튼 
    private JButton clearButton  = new JButton("clear");
    // 빨간 버튼 
    private JButton redButton  = new JButton("red");
    // 초록 버튼
    private JButton greenButton  = new JButton("green");
    // 파란 버튼
    private JButton blueButton  = new JButton("blue");

    // 생성자 
    public Main(String title) {
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(e -> {
            history.clear();
            canvas.init();
            canvas.repaint();
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

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(redButton);
        buttonBox.add(greenButton);
        buttonBox.add(blueButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        //히스토리 초기화
        history.append((new ColorCommand(canvas, Color.red)));

        pack();
        setVisible(true);
    }

    // MouseMotionListener용
    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    // WindowListener용
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowOpened(WindowEvent e) {}

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}

package practice.ch19;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// context를 구현, 화면을 보임
public class SafeFrame extends Frame implements ActionListener, Context {
    private TextField textClock = new TextField(60);		// 현재 시간 표시
    private TextArea textScreen = new TextArea(10, 60);	// 경비 센터 출력
    private Button buttonUse = new Button("금고 사용");	// 금고 사용 버튼
    private Button buttonAlarm = new Button("비상벨");	// 비상벨 버튼
    private Button buttonPhone = new Button("일반 통화");	// 일반 통화 버튼
    private Button buttonExit = new Button("종료");		// 종료 버튼

    private State state = DayState.getInstance();		// 현재 상태 (주간이 초기값)

    // 생성자 
    public SafeFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        // textClock 배치 
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false); // 편집 불가
        // textScreen 배치 
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false); // 편집 불가
        // 패널에 버튼 저장
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        // 그 패널을 배치 
        add(panel, BorderLayout.SOUTH);
        // 표시 
        pack();
        setVisible(true);
        // 리스너 설정 
        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }

    // 버튼이 눌리면 여기로 온다
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        //액션 이벤트가 어느 버튼에서 발생했는지 체크
        if (e.getSource() == buttonUse) {		// 금고 사용 버튼
            state.doUse(this); // (중요!!!!!!!) state = 현재 상태(주간, 야간)의 doUse()를 호출
        } else if (e.getSource() == buttonAlarm) {	// 비상벨 버튼 
            state.doAlarm(this);
        } else if (e.getSource() == buttonPhone) {	// 일반 통화 버튼  
            state.doPhone(this);
        } else if (e.getSource() == buttonExit) {	// 종료 버튼 
            System.exit(0);
        } else {
            System.out.println("?");
        }
    }

    // 시간 설정 
    @Override
    public void setClock(int hour) {
        String clockstring = String.format("현재 시간은 %02d:00", hour); //두 칸 출력, 앞에는 0으로 채우기
        System.out.println(clockstring);
        textClock.setText(clockstring);
        state.doClock(this, hour); // (중요) 상태 객체(state)에 현재 시각을 알려줌
    }

    // 상태 변화 
    @Override
    public void changeState(State state) {
        System.out.println(this.state + "에서" + state + "으로 상태가 변화했습니다.");
        this.state = state;
    }

    // 경비 센터 경비원 호출
    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append("call! " + msg + "\n");
    }

    // 경비 센터 기록 
    @Override
    public void recordLog(String msg) {
        textScreen.append("record ... " + msg + "\n");
    }
}

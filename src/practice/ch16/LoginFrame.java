package practice.ch16;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 구체적인 카운셀러(중재자) 역할
// Mediator 인터페이스를 구현, 로그인 대화상자를 나타내는 클래스
public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    // Colleague를 생성하고 배치한 후에 표시한다
    public LoginFrame(String title) {
        super(title);

        // 배경색을 설정한다
        setBackground(Color.lightGray);

        // 레이아웃 매니저를 사용해 4×2 그리드를 만든다
        setLayout(new GridLayout(4, 2));

        // Colleague를 생성한다 
        createColleagues();

        // 배치한다 
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);

        // 활성/비활성 초기 설정을 한다
        colleagueChanged();

        // 표시한다 
        pack();
        setVisible(true);
    }

    // Colleague를 생성한다
    @Override
    public void createColleagues() {
        // CheckBox
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);

        // TextField
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');

        // Button
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        // Mediator를 설정한다 
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        // Listener 설정
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    // Colleage의 상태가 바뀌면 호출된다
    @Override
    public void colleagueChanged() { // 통지 받는 메소드
        if (checkGuest.getState()) { // Guest 체크 박스가 선택되었다면..
            // 게스트 로그인 
            textUser.setColleagueEnabled(false); // 비활성화
            textPass.setColleagueEnabled(false); //  비활성화
            buttonOk.setColleagueEnabled(true); // 활성화
        } else { // 로그인 체크 박스가 선택되었다면 ..
            // 사용자 로그인 
            textUser.setColleagueEnabled(true); // 유저네임 입력창 활성화
            userpassChanged();
        }
    }

    // textUser 또는 textPass의 변경이 있다 
    // 각 Colleage의 활성/비활성을 판정한다
    private void userpassChanged() {
        if (textUser.getText().length() > 0) { // 글자가 입력되어 있으면 ..

            textPass.setColleagueEnabled(true); // 비밀번호 입력창 활성화

            if (textPass.getText().length() > 0) { // 비밀번호를 입력해야
                buttonOk.setColleagueEnabled(true); // OK 버튼 활성화
            } else { // 비밀번호가 입력되어 있지 않으면 .. 
                buttonOk.setColleagueEnabled(false); // OK 버튼 비활성화
            }
        } else { // 사용자 이름이 입력되어 있지 않으면 .. 
            textPass.setColleagueEnabled(false); // 비밀번호 입력창 활성화
            buttonOk.setColleagueEnabled(false); // OK 버튼 비활성화
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0); // 종료 ( 0 = 정상 종료라는 뜻)
    }
}

package hw.ch16;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;


public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueCheckbox checkMember;  // 추가
    private ColleagueTextField textUser;
    private ColleagueTextField textPass; 
    private ColleagueTextField textNumber; // 추가
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    // Colleague를 생성하고 배치한 후에 표시한다
    public LoginFrame(String title) {
        super(title);

        // 배경색을 설정한다
        setBackground(Color.lightGray);

        // 레이아웃 매니저를 사용해 5×2 그리드를 만든다
        setLayout(new GridLayout(5, 2)); // 수정

        // Colleague를 생성한다 
        createColleagues();

        // 배치한다 
        add(checkGuest);
        add(checkLogin);
        add(checkMember); // 추가
        add(new Label("Username:"));
        add(textUser);
        add(new Label("      ")); // 추가
        add(new Label("Password:"));
        add(textPass);
        add(new Label("      ")); // 추가
        add(new Label("주민등록번호:")); // 추가
        add(textNumber); // 추가
        add(new Label("      ")); // 추가
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
        checkMember = new ColleagueCheckbox("Member", g, false); // 추가

        // TextField
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textNumber = new ColleagueTextField("", 10); // 추가
        textPass.setEchoChar('*');

        // Button
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        // Mediator를 설정한다 
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        checkMember.setMediator(this); // 추가
        textUser.setMediator(this);
        textPass.setMediator(this);
        textNumber.setMediator(this); // 추가
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        // Listener 설정
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        checkMember.addItemListener(checkMember); // 추가
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        textNumber.addTextListener(textNumber); // 추가
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);

        // textNumber 조건 설정 (추가)
        textNumber.addTextListener(new TextListener() { //리스너
            public void textValueChanged(TextEvent e) {
                String input = textNumber.getText();
                for (int i = 0; i < input.length(); i++) {
                    if (!Character.isDigit(input.charAt(i))) { // 문자가 포함된 경우
                        JOptionPane.showMessageDialog(null, "주민번호는 숫자만 입력해야 합니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
                        String newText = input.substring(0, i) + input.substring(i + 1);
                        textNumber.setText(newText);
                        if(newText.length() > 0) textNumber.setCaretPosition(newText.length());
                        break;
                    }
                }
                colleagueChanged();
            }
        });
    }

    // Colleage의 상태가 바뀌면 호출된다
    @Override
    public void colleagueChanged() { // 통지 받는 메소드
        if (checkMember.getState()) { // Member 체크 박스가 선택되었다면.. (수정)
            // 멤버 로그인 
            textUser.setColleagueEnabled(true); 
            userpassChanged();
        } else { // 나머지 체크 박스가 선택되었다면 ..
            textUser.setColleagueEnabled(false); 
            textPass.setColleagueEnabled(false); 
            textNumber.setColleagueEnabled(false); 
            buttonOk.setColleagueEnabled(false); 
        }
    }

    private void userpassChanged() {
        if (textUser.getText().length() > 0) { // 글자가 입력되어 있으면 ..
            textPass.setColleagueEnabled(true); // 비밀번호 입력창 활성화

            if (textPass.getText().length() > 0) { // 비밀번호를 입력해야
                textNumber.setColleagueEnabled(true); // 주민번호 입력창 활성화 (추가)

                if(textNumber.getText().length() == 13) { // 주민번호를 입력해야 (추가)
                    buttonOk.setColleagueEnabled(true); // OK 버튼 활성화
                } else { // 주민번호가 입력되어 있지 않으면 .. 
                    buttonOk.setColleagueEnabled(false); // OK 버튼 비활성화
                }

            } else { // 비밀번호가 입력되어 있지 않으면 .. 
                textNumber.setColleagueEnabled(false); // 주민번호 입력창 비활성화 (추가)
                buttonOk.setColleagueEnabled(false); // OK 버튼 비활성화
            }
        } else { // 사용자 이름이 입력되어 있지 않으면 .. 
            textPass.setColleagueEnabled(false); // 비밀번호 입력창 비활성화
            textNumber.setColleagueEnabled(false); // 주민번호 입력창 비활성화
            buttonOk.setColleagueEnabled(false); // OK 버튼 비활성화
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0); // 종료 ( 0 = 정상 종료라는 뜻)
    }
}

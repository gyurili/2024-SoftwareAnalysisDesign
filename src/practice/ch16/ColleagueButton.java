package practice.ch16;

import java.awt.Button;

// Colleague 인터페이스를 구현, 버튼을 나타내는 클래스
public class ColleagueButton extends Button implements Colleague {
    
    private Mediator mediator;

    public ColleagueButton(String caption) {
        super(caption);
    }

    // Mediator를 설정한다 
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator에서 활성/비활성을 지시한다
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }
}

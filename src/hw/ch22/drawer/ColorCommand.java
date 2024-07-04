package hw.ch22.drawer;

import java.awt.Color;

import hw.ch22.command.Command;

//붓의 색깔을 바꾸는 커맨드
public class ColorCommand implements Command {
    // 도화지
    protected Drawable drawable;
    // 붓의 색깔 
    private Color color;

    // 생성자 
    public ColorCommand(Drawable drawable, Color color) {
        this.drawable = drawable;
        this.color = color;
    }

    // 실행 
    @Override
    public void execute() {
        // 도화지 붓 색깔을 변경
        drawable.setColor(color);
    }
}

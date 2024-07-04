package practice.ch22.drawer;

import java.awt.Color;

// "그리는 대상"을 표현하는 인터페이스
public interface Drawable {
    // 그리기
    public abstract void draw(int x, int y);
    // 색
    public abstract void setColor(Color color);
    public abstract void init();
}

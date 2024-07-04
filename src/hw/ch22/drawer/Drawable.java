package hw.ch22.drawer;

import java.awt.Color;

public interface Drawable {
    // 그리기
    public abstract void draw(int x, int y);
    // 색
    public abstract void setColor(Color color);
    public abstract void init();
}

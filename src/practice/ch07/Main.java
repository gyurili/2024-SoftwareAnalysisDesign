package practice.ch07;

import javax.swing.JFrame;


// 클라이언트(의뢰인) 역할
public class Main {
    public static void main(String[] args) {
        // TextBuilder 이용
        TextBuilder b1 = new TextBuilder();
        Director d1 = new Director(b1);
        d1.construct();
        System.out.println(b1.getTextResult());

        // HTMLBuilder 이용
        HTMLBuilder hb1 = new HTMLBuilder();
        Director d2 = new Director(hb1);
        d2.construct();
        System.out.println(hb1.getHTMLResult());

        // FrameBuilder 이용
        FrameBuilder fb1 = new FrameBuilder();
        Director d3 = new Director(fb1);
        d3.construct();
        JFrame frame = fb1.getFrameResult();
        frame.setVisible(true);
    
        
    }
}

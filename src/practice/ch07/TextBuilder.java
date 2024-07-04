package practice.ch07;

// 구체적인 건축자 2
// public class TextBuilder extends Builder {
public class TextBuilder implements Builder {
    private StringBuilder sb = new StringBuilder();
    // 방법 2) private String sb = new String();

    @Override
    public void makeTitle(String title) {
        // 방법 2) sb = sb + "==============================\n";
        sb.append("==============================\n");
        sb.append("[");
        sb.append(title);
        sb.append("]\n\n");
    }

    @Override
    public void makeString(String str) {
        sb.append("■");
        sb.append(str);
        sb.append("\n\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (String s: items) {
            sb.append("　- ");
            sb.append(s);
            sb.append("\n");
        }
        sb.append("\n");
    }

    @Override
    public void close() {
        sb.append("==============================\n");
    }

    public String getTextResult() { // 완성된 문서를 얻을 때 호출되는 메소드 
        return sb.toString();
    }
}

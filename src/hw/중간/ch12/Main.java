package hw.ch12;

public class Main {
    public static void main(String[] args) {
        System.out.println("20220526 박규리 ");
        
        MultiStringDisplay md = new MultiStringDisplay();

        md.add("ID: 20220526");
        md.add("name: ParkGyuri");
        md.add("Phone num: 010-1234-5678");


        Display display = new MultiSideBorder(
                            new UpDownBorder(
                                new FullBorder(
                                    new SideBorder(md, '%')
                                ),
                            '='),
                        '*', 3);
        display.show();
    }
}

package hw.ch17;

//구체적인 관찰자 3
public class NamePrintObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) { //수를 얻고
        //얻은 수만큼 이름 출력 (추가)
        for (int i=0 ; i < generator.getNumber() ; i++) {
            System.out.print("박규리 ");
        }
        System.out.println(""); 
        
        try {
            Thread.sleep(100); //출력 스피드를 늦춤
        } catch (InterruptedException e) {
        }
    }
}

package ch05.Q1;

public class TicketMaker {
    private int ticket = 1000;
    private static TicketMaker tm = new TicketMaker();

    private TicketMaker(){
    
    }

    public static TicketMaker getInstance(){
        return tm;
    }

    public int getNextTicketNumber() {
        return ticket++;
    }
}

package practice.ch19;

// 금고의 상태 변화를 관리, 경비센터와 연락
public interface Context {
    public abstract void setClock(int hour);			// 시간 설정 
    public abstract void changeState(State state);		// 상태 변화 
    public abstract void callSecurityCenter(String msg);	// 경비 센터 경비원 호출
    public abstract void recordLog(String msg);		// 경비 센터 기록 
}

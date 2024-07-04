package practice.ch19;

//state를 구현 (주간)
public class DayState implements State {
    private static DayState singleton = new DayState();

    private DayState() {
    }

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        //19-2 (hour < 8 || 17 <= hour) 범위 수정 필요
        if (hour < 9 || 17 <= hour) { // 현재 시간이 야간이면 ..
            context.changeState(NightState.getInstance()); // 야간 상태로 바꾸기 (context가 상태를 가지고 있기 때문에 context한테 요청)
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("금고사용(주간)");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(주간)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("일반 통화(주간)");
    }

    @Override
    public String toString() {
        return "[주간]";
    }
}

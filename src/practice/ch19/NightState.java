package practice.ch19;

//state를 구현 (야간)
public class NightState implements State {
    private static NightState singleton = new NightState();

    private NightState() {
    }

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        //19-2 (8 <= hour && hour < 21) 범위 수정 필요
        if (9 <= hour && hour < 17) { // 현재 시간이 주간이면 ..
            context.changeState(DayState.getInstance()); // 주간 상태로 바꾸기 (context가 상태를 가지고 있기 때문에 context한테 요청)
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("비상：야간 금고 사용！");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(야간)");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("야간 통화 녹음");
    }

    @Override
    public String toString() {
        return "[야간]";
    }
}

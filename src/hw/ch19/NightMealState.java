package hw.ch19;

public class NightMealState implements State {
    private static NightMealState singleton = new NightMealState();

    private NightMealState() {
    }

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) { // 시간 수정
        if (hour < 9 || hour >= 24) {
            context.changeState(NightState.getInstance());
        } else if (9 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        } else if (12 <= hour && hour < 13) {
            context.changeState(NoonState.getInstance());
        } else if (17 <= hour && hour < 20) {
            context.changeState(NightState.getInstance());
        }
    }


    // (1) 경비센터에 기록 (2)비상사태 통보
    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("금고 사용(야식)");
        context.callSecurityCenter("비상：야식 시간에 금고 사용！");
    }

    // 경비센터에 비상벨 통보
    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(야식)");
    }

    // 경비센터의 자동응답기가 호출
    @Override
    public void doPhone(Context context) {
        context.recordLog("야식 시간 통화 녹음 (야식)");
    }

    @Override
    public void doCCTV(Context context) { // (추가)
        context.recordLog("CCTV: Off");
    }

    @Override
    public String toString() {
        return "[야식 시간]";
    }
}
